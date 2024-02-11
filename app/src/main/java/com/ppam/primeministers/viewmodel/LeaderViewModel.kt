package com.ppam.primeministers.viewmodel

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.ppam.primeministers.data.Leader
import com.ppam.primeministers.repository.LeaderRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel for managing leader data.
 *
 * @param repository The repository for fetching leader data.
 */
class LeaderViewModel(private val repository: LeaderRepository) : ViewModel() {

    private val _leaders: MutableLiveData<List<Leader>> = MutableLiveData()
    val leaders: LiveData<List<Leader>> = _leaders

    // State for indicating whether data is currently being loaded
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    // State for holding error message, if any
    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    /**
     * Loads leaders from local storage if available, otherwise fetches them from Firebase Remote Config.
     */
    init {
        loadLeaders()
    }

    /**
     * Loads leaders from local storage if available, otherwise fetches them from Firebase Remote Config.
     */
    private fun loadLeaders() {
        viewModelScope.launch {
            try {
                // Set loading state to true
                _loading.value = true
                // Attempt to fetch leaders from local storage
                val localLeaders = repository.getLeadersFromLocalPreferences()
                if (localLeaders.isNotEmpty()) {
                    // If local data is available, update leaders state
                    _leaders.value = localLeaders
                } else {
                    // If local data is not available, fetch leaders from remote
                    fetchLeadersFromRemote()
                }
            } catch (e: Exception) {
                // Update error state if an exception occurs
                _error.value = "Error loading leaders: ${e.message}"
            } finally {
                // Set loading state to false after loading completes
                _loading.value = false
            }
        }
    }


    /**
     * Fetches leaders from Firebase Remote Config and saves them to local storage.
     */
    private fun fetchLeadersFromRemote() {
        viewModelScope.launch {
            repository.fetchLeadersFromRemoteConfig(
                onSuccess = { leaders ->
                    // Update leaders state with fetched data
                    _leaders.value = leaders
                    // Save fetched leaders to local storage
                    repository.saveLeadersToLocalPreferences(leaders)
                },
                onFailure = { exception ->
                    // Update error state if an exception occurs during remote fetch
                    _error.value = "Error fetching leaders from remote: ${exception.message}"
                }
            )
        }
    }

    /**
     * Retrieves a list of leaders from the repository.
     *
     * @return A list of leaders.
     */
    fun getLeaders(): List<Leader> {
        return repository.getLeadersFromLocalPreferences()
    }

    /**
     * Retrieves a leader by ID from the repository.
     *
     * @param id The ID of the leader to retrieve.
     * @return The leader with the specified ID, or null if not found.
     */
    fun getLeaderById(id: Int): Leader? {
        val leaders = repository.getLeadersFromLocalPreferences()
        return leaders.find { it.id == id }
    }

    /**
     * Fetches leaders from remote config.
     *
     * @param onSuccess Callback invoked with the list of leaders on successful fetch.
     * @param onFailure Callback invoked with an exception on fetch failure.
     */
    fun fetchLeadersFromRemoteConfig(
        onSuccess: (List<Leader>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        repository.fetchLeadersFromRemoteConfig(onSuccess, onFailure)
    }

    /**
     * Saves leaders to local preferences.
     *
     * @param leaders List of leaders to save.
     */
    fun saveLeadersToLocalPreferences(leaders: List<Leader>) {
        repository.saveLeadersToLocalPreferences(leaders)
    }

    /**
     * Retrieves leaders from local preferences.
     *
     * @return A list of leaders stored in local preferences.
     */
    fun getLeadersFromLocalPreferences(): List<Leader> {
        return repository.getLeadersFromLocalPreferences()
    }
}

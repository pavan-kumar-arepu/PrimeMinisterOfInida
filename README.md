# Indian Leaders alias "Prime Ministers App"

The **Prime Ministers app** is a mobile application that provides information about the prime ministers of India. It allows users to browse through a list of prime ministers, view detailed information about each prime minister, and learn about their contributions and tenure.

## Features

- Browse a list of prime ministers with their names and parties.
- View detailed information about each prime minister, including their party, ruling period, and a brief description.
- Navigate to a detailed screen for each prime minister to view additional information.

## Screenshots

![Leader List Screen](https://github.com/pavan-kumar-arepu/PrimeMinisterOfInida/assets/13812858/d077de8d-73c3-45b2-afff-92c7f5fe26a7)
![Detailed Leader Screen](https://github.com/pavan-kumar-arepu/PrimeMinisterOfInida/assets/13812858/9ea8bc6a-b588-4368-95b5-c5ba42028da2)

## Architecture

The app follows the **MVVM (Model-View-ViewModel)** architecture pattern. It separates the user interface (View) from the business logic (ViewModel) and data (Model). This separation of concerns helps in maintaining a clean and modular codebase.

## Technical Stack

- **Language:** Kotlin
- **Architecture:** MVVM (Model-View-ViewModel)
- **Jetpack Components:** ViewModel, LiveData, Navigation Component
- **Dependency Injection:** Dagger Hilt
- **Network:** Firebase Remote Config
- **Data Persistence:** SharedPreferences
- **UI Toolkit:** Jetpack Compose
- **Image Loading:** Coil

## Getting Started

To build and run the app locally, follow these steps:

1. Clone this repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the app on a device or emulator.

## Class Overview

- **LeaderViewModel:** Manages the presentation logic and data for the leader-related screens. It communicates with the repository to fetch and manipulate data.
- **LeaderRepository:** Acts as the single source of truth for leader data. It fetches data from local storage or remote sources and provides it to the ViewModel.
- **Leader:** Represents a prime minister entity with properties such as name, party, ruling period, and description.
- **LeaderListScreen:** Displays a list of prime ministers using Jetpack Compose. It observes data from the ViewModel and handles user interactions.
- **DetailedLeaderScreen:** Displays detailed information about a selected prime minister. It receives data from the ViewModel and presents it to the user.
- **LeaderViewModelFactory:** This class is responsible for creating instances of the LeaderViewModel. It takes an application context and provides a ViewModel instance with the necessary dependencies injected.

## Contributing

Contributions are welcome! If you have any ideas for improvements or new features, feel free to submit a pull request.


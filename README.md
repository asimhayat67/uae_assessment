# Android Assessment University App

This Android application showcases a list of universities and their details, following modern Android development practices.

## Project Overview

The project utilizes the MVVM architecture pattern along with Dagger Hilt for dependency injection. Here's a brief overview of the project structure:

- **app**: Main application code.
- **data**: Handles data operations.
  - **model**: Defines data models.
  - **repository**: Manages data sources.
    - **localdb**: Handles local database operations.
    - **remote**: Handles remote data fetching.
- **di**: Dependency injection modules.
- **ui**: User interface components.
  - **universitylist**: Fragments for displaying university lists and details.

## Features

- Display list of universities.
- View detailed information about each university.
- Refresh university list.

## Key Components

- **MainActivity**: Initializes the main activity and sets up edge-to-edge display.
- **UniversityDetailFragment**: Displays detailed information about a university.
- **UniversityListFragment**: Displays list of universities and handles refresh functionality.
- **UniversitiesUseCase**: Executes business logic for fetching universities.
- **UniversityViewModel**: Manages UI-related data for university fragments.
- **AppModule**: Provides dependencies using Dagger Hilt.
- **UniversityRepositoryImpl**: Implements repository interface for fetching universities.

## How to Use

1. Clone the repository.
- https://github.com/asimhayat67/uae_assessment.git
2. Open in Android Studio.
3. Build and run on emulator or device.
4. App live demo link
- https://drive.google.com/file/d/16agqJQ4U1x55DNHpVixkALQC_LOFQyVC/view?usp=sharing
5. App apk link
- https://drive.google.com/file/d/1xbRL5smgEHiEXzI1q8-CDF0QWOtyDhFs/view?usp=sharing

## Libraries Used

- Retrofit
- Room
- Dagger Hilt
- Kotlin Coroutines
- Navigation Component

## Conclusion
This Android application demonstrates modern Android development practices, including MVVM architecture and Dagger Hilt for dependency injection.
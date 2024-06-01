## MadarSoft Task - Data Management App
This project demonstrates a robust approach to managing and displaying data relevant to Madar Soft within an Android application.

## What have I Done in This Project
1. Applied Clean Architecture: I've structured the project using clean architecture principles.
This separates concerns into distinct layers:
Core: Contains the business logic independent of any platform.
Data: Handles data access from various sources.
Domain: Represents the domain-specific data models and logic.
Presentation (UI): Manages the user interface and interacts with the ViewModel.
Application: Glues the layers together for your specific Madar Soft application.
This structure improves the maintainability, testability, and reusability of your code.

2. Implemented MVI Architecture: I've adopted the Model-View-Intent (MVI) architecture to manage user interactions, application state, and data flow
. This likely involves:
ViewModels: Responsible for handling user actions (intent), updating the state (model), and potentially interacting with the data layer.
View State: Holds the data that the UI needs to render, such as the current data entry fields or loading states. The ViewModel exposes this state to the UI.
Single Source of Truth: The ViewModel acts as the single source of truth for the application state, ensuring consistency and reducing potential errors.
This approach leads to a more predictable and manageable way to handle data flow in your application.

3. Utilized Coroutines with Flow: I've incorporated coroutines for handling asynchronous operations like data fetching or saving. Kotlin Flow provides a reactive approach to data updates, ensuring a smooth user experience.
 This likely involves:
Launching background tasks using coroutines.
Using Flow to emit data updates from the ViewModel to the UI in a reactive manner.
Updating the View State based on the received data or errors.
This lets your application handle asynchronous operations efficiently and keep the UI responsive.

4. Built with Kotlin: The project utilizes Kotlin, the modern programming language for Android development.
 This likely includes:
Defining data models for Madar Soft data using Kotlin classes.
Implementing logic in the ViewModel and other layers using Kotlin functions and coroutines.
Kotlin offers advantages like type safety, null-safety features, and concise syntax compared to Java.

5. Used Jetpack Compose: You might have explored using Jetpack Compose to build the user interface.
 This likely involves:
Creating composable functions to define UI elements.
Building layout structures using Compose layout builders.
Updating the UI based on changes in the View State exposed by the ViewModel.
Jetpack Compose offers a modern and declarative way to build UIs in Android applications.

## Features
1. Data Entry: Users can enter and submit data points related to MadarSoft operations.
2. Data Display: The app can view previously entered data on a dedicated screen for review purposes.

## Benefits
Organized User Data: This application provides a centralized location for capturing and managing relevant data points.
Improved Efficiency: Streamline data collection and management processes within Madar Soft.
Offline Functionality: Implement local data storage (Room) for offline data entry and synchronization when internet connectivity resumes.

## Specifications
- Portrait and landscape, Clean architecture, MVI, Coroutines, Flow, Use-Cases, View State, Reactive code, Kotlin DSL, Jetpack Compose.

## Project Organization
* In this project I'm using [Clean architecture with MVI Pattern](https://developer.android.com/jetpack/docs/guide)
as an application architecture adopted with the usage of UseCases with these design patterns in mind:-
<img src="https://developer.android.com/topic/libraries/architecture/images/final-architecture.png"></a>
* Each component depends only on the component one level below it. For example, activities and Views depend only on a view model. The repository is the only class that depends on multiple other classes; in this example, the repository depends on a persistent data model and a remote backend data source.

## Benefits of Organization:

Each package encapsulates specific functionalities, making the codebase easier to navigate and understand.
MVI-related classes reside in the MVI package, promoting clarity and separation from UI elements.
The optional data package keeps data access logic isolated.

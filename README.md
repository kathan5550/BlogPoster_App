# Description
The BlogPost app is an Android application developed in Kotlin, following the MVVM (Model-View-ViewModel) architecture. It allows users to interact with a blogging platform, and perform CRUD operations on blog posts through a RESTful API using the Retrofit library. The app provides feedback on the status of these operations, indicating success or failure.

# Features
1. View Blog Posts:<br>
* See a list of blog posts with titles and summaries.<br>
* Tap on a post to view the full content.<be>

2. MVVM Architecture:<br>
* Separation of concerns: Model, View, ViewModel.<br>
* ViewModel manages UI-related data and communicates with the repository.<br>

3. Update Post:<br>
* Users can update existing blog posts.<br>
* Implement both PUT and PATCH methods for full and partial updates.<br>
* See status messages indicating whether the update was successful or failed.<br>

4. Delete Post:<br>
* Delete unwanted blog posts.<br>
* Confirmation dialog ensures the user intends to delete the post.<br>

5. Status Messages:<br>
* Clear status messages for each operation:<br>
* Successful post creation.<br>
* Successful post update.<br>
* Failed post update (with error message).<br>
* Successful post deletion.<br>
* Failed post deletion (with an error message).<br>

6. Error Handling:<br>
* Handle network errors gracefully, displaying appropriate messages.<br>
* Display user-friendly messages for API errors.<br>

### Technologies Used:
Kotlin <br>
MVVM architecture<br>
Retrofit for API calls<br>
JSON Parsing with Gson<br>
Dialogs for user interaction<br>


## MVVM Architecture:
The app follows the MVVM (Model-View-ViewModel) architecture pattern:

Model: Represents the data and business logic.
View: Represents the UI elements and interacts with the ViewModel.
ViewModel: Manages UI-related data and communicates with the repository.

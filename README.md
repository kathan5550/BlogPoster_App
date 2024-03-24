# Description
The BlogPost app is an Android application developed in Kotlin, allowing users to interact with a blogging platform. Using the Retrofit library, users can read, create, update, and delete blog posts through a RESTful API. The app provides feedback on the status of these operations, indicating success or failure.

# Features
1. View Blog Posts:<br>
* See a list of blog posts with titles and summaries.<br>
* Tap on a post to view the full content.<br>

2. Update Post:<br>
* Users can update existing blog posts.<br>
* Implement both PUT and PATCH methods for full and partial updates.<br>
* See status messages indicating whether the update was successful or failed.<br>

3. Delete Post:<br>
* Delete unwanted blog posts.<br>
* Confirmation dialog ensures the user intends to delete the post.<br>

4. Status Messages:<br>
* Clear status messages for each operation:<br>
* Successful post creation.<br>
* Successful post update.<br>
* Failed post update (with error message).<br>
* Successful post deletion.<br>
* Failed post deletion (with an error message).<br>

5. Error Handling:<br>
* Handle network errors gracefully, displaying appropriate messages.<br>
* Display user-friendly messages for API errors.<br>

# Technologies Used:
Kotlin <br>
Retrofit for API calls<br>
JSON Parsing with Gson<br>
Dialogs for user interaction<br>

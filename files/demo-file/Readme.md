
By default, build tools like Maven, Gradle, or common Java practice will copy all
files from src/main/resources to the root of **target/classes** or **build/classes**. So,
when we try to read a file from **src/main/resources**, we read the file from the root of 
the project classpath.

jar -tf target/example.jar
# crxrainyhills
CRXMarkets challenge RainyHills.pdf


## Dependencies
The application is built with JDK 17 and runs on JRE 17. 
Having these packages installed on your system is required for compiling and running the application respectively.
Installation instructions (for Debian-based Linux distributions):

```sh
$ sudo apt-get install openjdk-17 openjdk-17-jre
```
or a similar command depending on your package manager.

## Running in Docker
The application can also be run in Docker. This requires a JDK 17 to build the application and Docker Engine to run the Docker container.
This can be achieved with the following commands.
```sh
# Build the application into a .jar file.
$ sh gradlew build

# Create a docker image.
$ docker build --build-arg JAR_FILE=build/libs/\*.jar -t luptak/crx-rainy-hills-docker .

# Run the docker image as a web server on port 8080 (Spring Boot default).
$ docker run -p 8080:8080 luptak/crx-rainy-hills-docker
```

## Complexity
The application uses `RainCalculatorImpl` class which calculates the result in linear time `O(n)`
and constant memory usage `O(1)`.

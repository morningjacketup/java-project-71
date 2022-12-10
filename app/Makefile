.PHONY: build

run-dist:
	./build/install/app/bin/app ./src/test/resources/file1.json ./src/test/resources/file2.json

run-dist2:
	./build/install/app/bin/app ./src/test/resources/yaml1.yml ./src/test/resources/yaml2.yml

run-dist3:
	./build/install/app/bin/app ./src/test/resources/emptyjson.json ./src/test/resources/emptyjson2.json

clean-run: clean-install run-dist


clean-install:
	./gradlew clean installDist


install:
	./gradlew clean install


build:
	./gradlew clean build



test:
	./gradlew test

report:
	./gradlew jacocoTestReport
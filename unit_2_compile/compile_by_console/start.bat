call javac -sourcepath ./src -d build/classes -cp ./libs/commons-lang3-3.11.jar;./libs/commons-math3-3.6.1.jar;. src/ua/com/alevel/math/Math.java src/ua/com/alevel/console/Console.java src/ua/com/alevel/Compile.java
call java -cp build/classes;./libs/commons-lang3-3.11.jar;./libs/commons-math3-3.6.1. ua.com.alevel.Compile

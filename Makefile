CC = gcc

CFLAGS = -Wall -I/usr/lib/jvm/java-7-openjdk-amd64/include -fPIC -std=c99
LDFLAGS = -shared
OBJS = TestJNI.o


all: TestJNI.class libtestjni.so

libtestjni.so: TestJNI.h ${OBJS}
	$(CXX) -o $@ $(LDFLAGS) ${OBJS}

clean:
	rm -f *.class
	rm -f *.o
	rm -f *.so
	rm -f TestJNI.h

%.class: %.java
	javac $^

%.h: %.class
	javah $*

%.o: %.cpp
	$(CXX) -c $(CXXFLAGS) $^ -o $@

%.o: %.c
	$(CC) -c $(CFLAGS) $^ -o $@

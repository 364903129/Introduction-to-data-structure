JAVASRC    = Bard.java Node.java
SOURCES    = README Makefile $(JAVASRC)
MAINCLASS  = Bard
CLASSES    = Bard.class Node.class
JARFILE    = Bard.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest

$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)

clean:
	rm $(CLASSES) $(JARFILE)

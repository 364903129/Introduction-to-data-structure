JAVASRC = Balanced.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = Balanced
CLASSES = Balanced.class Node.class StackReferenceBased.class
JARFILE = Balanced.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)
clean:
	rm $(CLASSES) $(JARFILE)

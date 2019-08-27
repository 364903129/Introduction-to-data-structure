JAVASRC = ChessBoard.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = ChessBoard
CLASSES = ChessBoard.class King.class Queen.class Rook.class Bishop.class Node.class ChessPiece.class linkList.class 
JARFILE = ChessBoard.jar

all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)
clean:
	rm $(CLASSES) $(JARFILE)

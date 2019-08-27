#include "queue.h"
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include "queue.h"
#include"queue.c"

int main(int argc, char* argv[]) {

	FILE* in;
	FILE* out;
	char word[80];
	in = fopen(argv[1], "r");
	if (in == NULL) {
		printf("unable to read input file %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}

	out = fopen(argv[2], "w");
	if (out == NULL) {
		printf("unable to write output file %s\n", argv[2]);
	}

	struct Queue *q = createQueue();

	while (fgets(word, 80, in) != NULL) {
		int length = strlen(word);
		if (word[0] == 'E') {
			enQueue(q, word[2]);
			enQueue(q, word[3]);
			fprintf(out, "%s %c%c\n", "Enqueue", word[2], word[3]);
		}
		if (word[0] == 'D') {
			if(q->front == NULL){
				fprintf(out, "%s\n", "Dequeue fails");
			}else{
			struct QNode *n = deQueue(q);
			fprintf(out, "Dequeue %c", n->value);
			struct QNode *a = deQueue(q);
			fprintf(out, "%c\n", a->value);
			}
		}
		if (word[0] == 'P') {
			if (q->front == NULL) {
				fprintf(out, "%s\n", "Queue is empty");
			} else {
				struct QNode *n = peek(q);
				fprintf(out, "%s ", "Queue is");
				for (n = q->front; n; n = n->next->next) {
					fprintf(out, "%c", n->value);
					fprintf(out, "%c ", n->next->value);
				}
					fprintf(out, "\n");
			}
		}
	}
	fclose(in);
	fclose(out);
}

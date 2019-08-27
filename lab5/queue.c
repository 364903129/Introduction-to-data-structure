#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include "queue.h"

struct QNode {
	int value;
	struct QNode *next;
};

struct Queue {
	struct QNode *front, *back;
};

struct QNode* newNode(int k) {
	struct QNode *temp = (struct QNode*) malloc(sizeof(struct QNode));
	temp->value = k;
	temp->next = NULL;
	return temp;
}

struct Queue *createQueue() {
	struct Queue *q = (struct Queue*) malloc(sizeof(struct Queue));
	q->front = q->back = NULL;
	return q;
}

void enQueue(struct Queue *q, int k) {
	// Create a new node
	struct QNode *temp = newNode(k);

	// If queue is empty, then new node is front and rear both
	if (q->back == NULL) {
		q->front = q->back = temp;
		return;
	}

	// Add the new node at the end of queue and change back
	q->back->next = temp;
	q->back = temp;
}

struct QNode *deQueue(struct Queue *q) {
	// If queue is empty, return NULL.
	if (q->front == NULL)
		return NULL;

	// Store previous front and move front one node ahead
	struct QNode *temp = q->front;
	q->front = q->front->next;

	// If front becomes NULL, then change rear also as NULL
	if (q->front == NULL)
		q->back = NULL;
	return temp;
}

struct QNode *peek(struct Queue *q) {
	if (q->front == NULL) {
		return NULL;
	} else {
		struct QNode *temp = q->front;
		return temp;
	}
}

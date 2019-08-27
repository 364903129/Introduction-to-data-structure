struct QNode;
struct Queue;
struct QNode* newNode(int k);
struct Queue *createQueue();
void enQueue(struct Queue *q, int k);
struct QNode *deQueue(struct Queue *q);
struct QNode *peek(struct Queue *q);

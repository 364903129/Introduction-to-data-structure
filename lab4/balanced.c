/* Haofan Wang
hwang108
*/
#include<stdio.h>
#include<stdlib.h>
#include <string.h>

#define MAXSIZE 80
#define TRUE 1
#define FALSE 0

void initialize();
/*void trim(char *s);*/
int peek();
int isFull();
int isEmpty();
int pop();
void push(int num);

int main(int argc, char* argv[]) {
	char word[80];
	int i;

	FILE* in;
	FILE* out;
	if (argc != 3) {
		printf("Usage: %s <input file> <output file>\n", argv[0]);
		exit(EXIT_FAILURE);
	}

	in = fopen(argv[1], "r");
	if (in == NULL) {
		printf("Unable to read from file %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}

	out = fopen(argv[2], "w");
	if (out == NULL) {
		printf("Unable to write to file %s\n", argv[2]);
		exit(EXIT_FAILURE);
	}
	while (fgets(word, 80, in) != NULL) {
		initialize();
		int isBalanced = 1;
		printf("%s\n", word);
		int length = strlen(word);
		for(i = 0; i < length; i++){
			if(word[i] == '{'){
				push(word[i]);
			}
			else if(word[i] == '}'){
				if(!isEmpty() && peek() == '{'){
				pop();
				}else{
					isBalanced = 0;
				}
			}
			if(word[i] == '<'){
				push(word[i]);
			}
			else if(word[i] == '>'){
				if(!isEmpty() && peek() == '<'){
				pop();
				}else{
					isBalanced = 0;
				}
			}
			if(word[i] == '['){
				push(word[i]);
			}
			else if(word[i] == ']'){
				if(!isEmpty() && peek() == '['){
				pop();
				}else{
					isBalanced = 0;
				}
			}
			if(word[i] == '('){
				push(word[i]);
			}
			else if(word[i] == ')'){
				if(!isEmpty() && peek() == '('){
				pop();
				}else{
					isBalanced = 0;
				}
			}
			else{
				int k =1;
				k++;
			}
		}
	if(isEmpty() && isBalanced == 1){
		fprintf(out, "Y\n");
	}
		else{
			fprintf(out, "N\n");
		}
	}
	/* close input and output files */
	fclose(in);
	fclose(out);
	return (EXIT_SUCCESS);
}

struct Stack {
	int top;
	int array[MAXSIZE];
} st;
void initialize() {
	st.top = -1;
}

/*
 Checks if Stack is Full or not
 */
int isFull() {
	if (st.top >= MAXSIZE - 1)
		return TRUE;
	else
		return FALSE;
}

/*
 Checks if Stack is Empty or not
 */
int isEmpty() {
	if (st.top == -1)
		return TRUE;
	else
		return FALSE;
}

/*
 Adds an element to stack and then increment top index
 */
void push(int num) {
	if (isFull())
		printf("Stack is Full...\n");
	else {
		st.array[st.top + 1] = num;
		st.top++;
	}
}

/*
 Removes top element from stack and decrement top index
 */
int pop() {
	if (isEmpty()){
		printf("Stack is Empty...\n");
	return 0;}
	else {
		st.top = st.top - 1;
		return st.array[st.top + 1];
	}
}

int peek(){
	if(!isEmpty()){
		return st.array[st.top];
	}
	else{
		printf("Stack is Empty...\n");
		return 0;
	}
}

/*void trim(char *s){
	char *p = s;
	int len;
	while(*p == ' ' && *p != '\0'){
		p++;
	}
	len = strlen(p);
	memmove(s,p,len+1);
}*/


#include <stdio.h>

#define NO_OF_CHARS 256

struct countIndex {
	int count;
	int index;
};

struct countIndex *getCharCountArray(char *str) {
	
	struct countIndex *count = (struct countIndex *)calloc(sizeof(struct countIndex), NO_OF_CHARS);

	int i = 0;
	for(i = 0; *(str + i); ++i) {
		(count[*(str+i)].count)++;
		if(count[*(str+i)].count == 1) {
			count[*(str+i)].index = i;
		}
	}
	return count;
}

int firstNonRepeating(char *str) {
	struct countIndex *count = getCharCountArray(str);
	int result = INT_MAX, i;

	for(i = 0; i < NO_OF_CHARS; ++i) {
		if(count[i].count == 1 && result > count[i].index) {
			result = count[i].index;
		}
	}
	free(count);
	return result;
}

int main() {
	char str[] = "geeksforgeeks";
	int index = firstNonRepeating(str);
	if(index == INT_MAX) {
		printf("all are repeating\n");
	} else {
		printf("First non-repeating char is %c\n", str[index]);
	}

	getchar();
	return 0;
}





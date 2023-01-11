#include <bits/stdc++.h>
using namespace std;

struct Node {
	int data;
	struct Node* next;
};

int countCommonNodes(struct Node* head1, struct Node* head2)
{
	struct Node* current1 = head1;

	struct Node* current2 = head2;

	int count = 0;

	while (current1 != NULL) {
		while (current2 != NULL) {
			if (current1->data == current2->data)
				count++;
			current2 = current2->next;
		}
		current1 = current1->next;
		current2 = head2;
	}
	return count;
}

void push(struct Node** head_ref, int new_data)
{
	struct Node* new_node = new Node;
	new_node->data = new_data;
	new_node->next = *head_ref;
	*head_ref = new_node;
}

void printList(struct Node* head)
{
	while (head != NULL) {
		cout << head->data << " ";
		head = head->next;
	}
	cout << endl;
}

int main()
{
	struct Node* head1 = NULL;
	struct Node* head2 = NULL;

	push(&head1, 17);
	push(&head1, 10);
	push(&head1, 12);
	push(&head1, 4);
	push(&head1, 3);

	push(&head2, 12);
	push(&head2, 34);
	push(&head2, 575);
	push(&head2, 8);
	push(&head2, 4);
	push(&head2, 10);

	cout << "Given Linked List A: \n";
	printList(head1);

	cout << "Given Linked List B: \n";
	printList(head2);

	int count = countCommonNodes(head1, head2);

	cout << "Number of common node in both list is = " << count;
	return 0;
}

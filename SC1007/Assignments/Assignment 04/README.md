# Assignment 04  

## Finding Largest Binary Search Subtree  
Guide - Check if a tree is a valid binary search subtree:  

    int checkBST(BTNode* root, BTNode* minimumNode, BTNode* maximumNode){
        
        if(root == NULL){
            return 1;
        }
        if(minimumNode != NULL && root->item <= minimumNode->item){
            return 0;
        }
        if(maximumNode != NULL && root->item >= maximumNode->item){
            return 0;
        }
        return checkBST(root->left, minimumNode, root) && checkBST(root->right, root, maximumNode);
    }

1) Create a function [checkBST] to check if a tree is a valid BST  
2) Create a function [count] to count the number of nodes in a tree.  
3) Create a function [compare] to compare the largest count (function is BTNode* function and should return BTNode*) (Make use of count here)  
4) The given function [findLargestBST] should be [ return compare(findLargestBST(root->left), findLargestBST(root->right)); ]  

Unable to check test case. Hopefully someone can share the problem they faced.  

## Correction of Binary Search Tree  
Inputs #01 - Should be testing if a grandchild node is smaller than root node on the right side, bigger than root node on the left side. testcase: `3 1 4 -1 -1 2 -1 a`  

![image](https://user-images.githubusercontent.com/32679064/194700885-3015e046-a3a0-4f5f-abf2-94283f8c7745.png)  
For those having trouble with Assignment 4 BSTCorrection test case 1, I believe its because there isn't a check which checks whether the grandchild node is smaller than the root node on the right subtree, and grandchild node is greater than the root on the left subtree. If anyone has figured it out please share how you approach this check

Guide - Unable to use recursive. If you used recursive and all test case work, please contact me as I want to know how.  
1) Through a while loop, we store the nodes in a queue (inorder traversal)  
2) Create another while loop, through that while loop, we will store and dequeue the first item [NODE1]. This will be our node used for comparison  
3) Inside the while loop, use a for loop to loop queue.size times. Inside the for loop, we will store and dequeue the next item in the queue [NODE2]. Using [NOED2], we compare against [NODE1].   
4) After comparison, we enqueue [NODE2] back into the queue.  
5) By right, the logic should go like: If there are 3 nodes in the queue, then in (STEP 2), the 1st node will be taken out. The queue will be left with 2 nodes, then loop queue.size times (2 times), each time dequeue the first node in the queue, then compare, then put back the node again. The first iteration will be left with 2 nodes in queue. Then 2nd iteration, we will take out the first node from the queue. Queue is left with 1 node. Do it until queue is empty.  

Illustration on what I explained above:  

https://user-images.githubusercontent.com/32679064/194700955-8967c14c-2c5a-4374-a020-69a5a2e34d8c.mp4

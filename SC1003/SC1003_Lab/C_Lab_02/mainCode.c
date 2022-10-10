#include <stdio.h> /* function prototypes */ 
int numDigits1(int num);
void numDigits2(int num, int *result);

int digitPos1(int num, int digit);
void digitPos2(int num, int digit, int *result);

int square1(int num);
void square2(int num, int *result); 

int main() 
{ 
   int choice; 
   int number, digit, result=0; 
   do { 
      printf("\nPerform the following functions ITERATIVELY:\n");
      printf("1:  numDigits1()\n");      
      printf("2:  numDigits2()\n"); 
      printf("3:  digitPos1()\n"); 
      printf("4:  digitPos2()\n"); 
      printf("5:  square1()\n");  
      printf("6:  square2()\n");         
      printf("7:  quit\n"); 
      printf("Enter your choice: "); 
      scanf("%d", &choice); 
    
      switch (choice) { 
         case 1:            
            printf("Enter the number: \n"); 
            scanf("%d", &number); 
            printf("numDigits1(): %d\n", numDigits1(number));               
            break;                
         case 2:  
            printf("Enter the number: \n"); 
            scanf("%d", &number); 
            numDigits2(number, &result); 
            printf("numDigits2(): %d\n", result); 
            break;         
         case 3:  

            printf("Enter the number: \n"); 
            scanf("%d", &number); 
            printf("Enter the digit: \n"); 
            scanf("%d", &digit);             
            printf("digitPos1(): %d\n", digitPos1(number, digit));            
            break;                         
         case 4:  
            printf("Enter the number: \n"); 
            scanf("%d", &number); 
            printf("Enter the digit: \n"); 
            scanf("%d", &digit);   
            digitPos2(number, digit, &result);           
            printf("digitPos2(): %d\n", result);            
            break;      
         case 5:  
            printf("Enter the number: \n"); 
            scanf("%d", &number); 
            printf("square1(): %d\n", square1(number));                            break; 
         case 6:  
            printf("Enter the number: \n"); 
            scanf("%d", &number); 
            square2(number, &result); 
            printf("square2(): %d\n", result);                            break;                   
         default: printf("Program terminating .....\n");             break; 
      }  
   } while (choice < 7); 
   return 0; 
} 



/* add function code here */ 
int numDigits1(int num) 
{ 
   int count = 0; 
   do { 
      count++; 
      num = num/10; 
   } while (num > 0);    
   return count; 
} 
void numDigits2(int num, int *result) 
{ 
   /* Write your code here */ 
    (*result) = 0;
    do { 
      (*result)++; 
      num = num/10; 
      } while (num > 0);

} 
int digitPos1(int num, int digit)  
{ 
   /* Write your code here */
    int pos=0;
   
   do { 
       pos++; 
       if (num%10 == digit){
           return pos;
       } 
       num = num/10; 
    } while (num > 0);
    return 0;
} 
void digitPos2(int num, int digit, int *result)  
{ 
   int pos=0; 
   *result=0; 
   do { 
      pos++; 
      if (num%10 == digit){ 
         *result = pos; 
         break; 
      } 
      num = num/10; 
   } while (num > 0);    
} 
int square1(int num) 
{  
   /* Write your code here */ 
    int result = 0;
    for (int i = 0; i < num; i++){
        result += 2*(i) + 1;
    }
    return result;
}   
void square2(int num, int *result) 
{        
   /* Write your code here */
    (*result) = 0;
    for (int i = 0; i < num; i++){
        (*result) += 2*(i) + 1;
    }
}   

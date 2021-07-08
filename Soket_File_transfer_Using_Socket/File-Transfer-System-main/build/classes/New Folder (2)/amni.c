#include<stdio.h>
int main()
{
    int i,j,n=50,m=10;

    for(i=1;i<m+1;i++)
    {
        for(j=1;j<n+1;j++)
        {
            if(i==m||i==1||j==n||j==1)
            {
                printf("*");
            }
            else
                printf("#");
        }
         printf("\n");
    }
}

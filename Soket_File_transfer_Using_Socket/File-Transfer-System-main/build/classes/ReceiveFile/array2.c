#include<stdio.h>
#include<string.h>
int main()
{
    int i,j;
    char temp,a[]="ismail";
    i=strlen(a);
    printf("%d\n",i);
    for(j=0;j<i-1;j++)
    {
        temp=j[i];
        j[i+1]=j[i];
        temp=j[i+1];
    }
    return 0;
}


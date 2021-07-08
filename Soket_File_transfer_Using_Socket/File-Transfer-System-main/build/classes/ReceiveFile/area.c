#include<stdio.h>
int main()
{
    double a,b,distance;
   while(scanf("%lf%lf",&a,&b)!=0){
   distance=(a*b)/12;
   printf("%.3lf\n",distance);
   }

    return 0;
}

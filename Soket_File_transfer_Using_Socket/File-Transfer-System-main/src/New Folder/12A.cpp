#include<bits/stdc++.h>
using namespace std;
int main()
{
    //int a[4][4];
    string a;
    string b;
    string c;
    cin>>a>>b>>c;
    if(a[0]==c[2] && a[1]==c[1] && a[2]==c[0] && b[0]==b[2] && b[1]==b[1])
    {
        cout<<"YES"<<endl;
    }
    else
    {
        cout<<"NO"<<endl;
    }
}

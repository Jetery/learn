#include <stdio.h>

int main()
{
    int m,n,a,sum,i;
    while(scanf("%d",&a)!=EOF)
    {
        if(a==0)break;
        i=a;
        n=0;
        sum=0;
        while(i--)
        {

            scanf("%d",&m);
            if(m>n)
            {
                sum=sum+(m-n)*6+5;
                n=m;
            }
            else
            {
                sum=sum+(n-m)*4+5;
                n=m;
            }
        }
        printf("%d\n",sum);
    }

    return 0;
}

//int main() {
//            int a = 0;
//            while (scanf("%d",&a) != EOF)
//            {
//                int sum = 0;
//                for (int i = 1;i <= a;i++)
//        {
//            sum += i;
//        }
//        printf("%d\n",sum);
//        printf("\n");
//    }
//    return 0;
//}


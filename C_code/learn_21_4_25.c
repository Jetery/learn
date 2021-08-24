#include <stdio.h>
#include <math.h>

int isPrime(long n)
{
	if (n == 1)
		return 0;
	else if (n == 3)
		return 1;
	else {
		long temp, i;
		temp = n % 6;
		if (temp != 1 && temp != 5)
			return 0;

		temp = sqrt(n);
		for (i = 3; i <= temp; i += 2)
		if (n % i == 0)
			return 0;

		return 1;
	}
}

int main(void)
{
	long m;
	scanf("%ld", &m);

	if (isPrime(m))
		printf("yes\n");
	else
		printf("no\n");
	return 0;
}

/*
int sum(int a, int b)
{
    return a + b;
}

int main()
{
    int n, a, b;
    scanf("%d",&n);
    while (n--)
    {
        scanf("%d%d",&a,&b);
        printf("%d\n",sum(a,b));
    }
    return  0;
}
*/
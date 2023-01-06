#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<signal.h>

void sighandler(int signum)
{
    printf("terminate\n");
    exit(0);
}

int main()
{
    signal(SIGINT,sighandler);
    while(1)
    {
        printf("开始休眠\n");
        sleep(1);
    }
    return(0);
}
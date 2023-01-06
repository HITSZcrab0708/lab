#include <stdio.h>
#include <sys/types.h>
#include <signal.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/wait.h>

void sighandler()
{
    printf("received a signal\n");
    exit(0);
}
int main()
{
    int child_pid;
    if((child_pid=fork())==0)
    {
        signal(SIGTERM,sighandler);
        while(1);
        printf("forbidden zone\n");
        exit(0);
    }
    else{
        while(getc(stdin))
        {
            kill(child_pid,SIGTERM);
            wait(0);
            exit(0);
        }
    }
}
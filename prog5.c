#include<stdio.h>
int main()
{
int i,f,w,frames[50];
printf("Enter the window size:");
scanf("%d",&w);

printf("Enter the number of frames:");
scanf("%d",&f);

printf("Enter the frames ");
for(i=1;i<=f;i++)
scanf("%d",&frames[i]);
printf("With Sliding Windows Protocol frames are received and an acknowledgement is sent to the sender");
printf("The %d frames are sent to the receiver",w);
for(i=1;i<=f;i++)
{
if(i%w==0)
{
printf("%d",frames[i]);
printf("Acknowledgement for the above frames is received by the sender");
}
else
{
System.out.println("%d",frames[i]);
}
}
if(i%w!=0)
{
printf("Acknowledgement for the above frames is received by the sender");
}
return 0;
}
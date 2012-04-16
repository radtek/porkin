#ifndef _BALLUTILS_H_
#define _BALLUTILS_H_

#include "ball.h"
#include <iostream>

using namespace std;

void swapBall(Ball* a, Ball* b)
{
    Ball* pt  = a;
    a = b;
    b = pt;
}

void displayBalls(Ball* ball)
{
    int count = ball->GetNumber();
    for(int i=1;i<=count;i++)
    {
        ball++;
        cout<<"\t"<<ball->GetNumber()<<"\t"<<ball->GetColorName()<<"\t"<<ball->GetCount()<<endl;
    }

}

void sortBall(Ball* ball)
{
    int count = ball->GetNumber();
    cout<<"Count="<<count<<endl;
    for(int i=1;i<=count;i++)
    {
        for(int j=1;j<=count-i;j++)
        {
            int iValue = (ball+j+1)->GetCount();
            int jValue = (ball+j)->GetCount();
            if(iValue<jValue)
            {
                Ball pt = ball[j+1];
                ball[j+1] = ball[j];
                ball[j] = pt;
                //swapBall(&ball[j+1], &ball[j]);
            }
        }
    }

}



#endif // _BALLUTILS_H_

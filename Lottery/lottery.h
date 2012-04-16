#ifndef _LOTTERY_H_
#define _LOTTERY_H_

#include<iostream>
using namespace std;

class Lottery
{

public:
    Lottery();
    Lottery(const string& id,const string& release_day,int red1,int red2,int red3,int red4,int red5,int red6,int blue);
    string toString();

    const string& Getid() const
    {
        return m_id;
    }

    const string& Getrelease_day() const
    {
        return m_release_day;
    }

    const int Getred1() const
    {
        return m_red1;
    }

    const int Getred2() const
    {
        return m_red2;
    }

    const int Getred3() const
    {
        return m_red3;
    }

    const int Getred4() const
    {
        return m_red4;
    }

    const int Getred5() const
    {
        return m_red5;
    }

    const int Getred6() const
    {
        return m_red6;
    }

    const int Getblue() const
    {
        return m_blue;
    }

    bool hasRedNumber(int number);
    bool hasBlueNumber(int number);

protected:

    string m_id;
    string m_release_day;
    int m_red1;
    int m_red2;
    int m_red3;
    int m_red4;
    int m_red5;
    int m_red6;
    int m_blue;
};

#endif // _LOTTERY_H_

#include "lottery.h"
#include<sstream>
#include<iostream>

using namespace std;

Lottery::Lottery()
{
}

Lottery::Lottery(const string& id,const string& release_day,int red1,int red2,int red3,int red4,int red5,int red6,int blue)
{
    m_id.assign(id);
    m_release_day.assign(release_day);
    m_red1 = red1;
    m_red2 = red2;
    m_red3 = red3;
    m_red4 = red4;
    m_red5 = red5;
    m_red6 = red6;
    m_blue = blue;
}

string Lottery::toString()
{
    stringstream ssout;
    ssout<<"[Id:"<<m_id<<",";
    ssout<<"Release_Day:"<<m_release_day<<",";
    ssout<<"Red1:"<<m_red1<<",";
    ssout<<"Red2:"<<m_red2<<",";
    ssout<<"Red3:"<<m_red3<<",";
    ssout<<"Red4:"<<m_red4<<",";
    ssout<<"Red5:"<<m_red5<<",";
    ssout<<"Red6:"<<m_red6<<",";
    ssout<<"Blue:"<<m_blue<<"]";
    return ssout.str();
}

bool Lottery::hasRedNumber(int n)
{
    return (m_red1==n)||(m_red2==n)||(m_red3==n)||(m_red4==n)||(m_red5==n)||(m_red6==n);
}


bool Lottery::hasBlueNumber(int n)
{
    return (m_blue==n);
}

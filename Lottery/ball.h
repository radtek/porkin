#ifndef _BALL_H_
#define _BALL_H_

#include <iostream>
using namespace std;

enum Color{Red,Blue};
const string red = "red";
const string blue = "blue";
class Ball
{
public:
    Ball();
    Ball(Color clor,int number);

    const int GetNumber() const
    {
        return m_number;
    }

    const int GetCount() const
    {
        return m_count;
    }

    const string& GetColorName() const
    {
        if(m_color==Red)
        {
            return red;
        }
        else
        {
            return blue;
        }
    }

    Ball& operator++()
    {
        ++m_count;
        return *this;
    }

    const Ball operator++(int)
    {
        Ball tmp = *this;
        ++(*this);
        return Ball(tmp);
    }

private:
    int m_count;
    int m_number;
    Color m_color;

};

#endif // _BALL_H_

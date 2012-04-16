#include "CppSQLite3.h"
#include "constants.h"
#include "ball.h"
#include "lottery.h"
#include "ballutils.h"
#include <ctime>
#include <iostream>
#include <vector>
#include <cstring>


using namespace std;

int main(int argc, char *argv[])
{
    try
    {
        //int i, fld;
        //time_t tmStart, tmEnd;
        CppSQLite3DB db;

        cout << "SQLite Version: " << db.SQLiteVersion() << endl;

        db.open(gszFile);

        int countRow = db.execScalar(count_SQL);
        cout <<"\tTotally "<<countRow<<" row(s) in lucky table!  "<<endl;


        // Initial Red Ball
        cout<<"\tInitial Red Ball..."<<endl;
        Ball redBalls[34];
        redBalls[0] = Ball(Red,33);
        for(int i=1;i<34;i++)
        {
            redBalls[i] = Ball(Red,i);
        }

        // Initial Blue Ball
        cout<<"\tInitial Blue Ball..."<<endl;
        Ball blueBalls[17];
        blueBalls[0] = Ball(Blue,16);
        for(int i=1;i<17;i++)
        {
            blueBalls[i] = Ball(Blue,i);
        }

        CppSQLite3Table t = db.getTable(getAll_SQL);

        vector<Lottery> allLottery(countRow);
        for (int row = 0; row < t.numRows(); row++)
        {
            t.setRow(row);
            string id = string(t.fieldValue(0));
            string rd = string(t.fieldValue(1));
            int r1 = t.getIntField(2);
            int r2 = t.getIntField(3);
            int r3 = t.getIntField(4);
            int r4 = t.getIntField(5);
            int r5 = t.getIntField(6);
            int r6 = t.getIntField(7);
            int b = t.getIntField(8);

            redBalls[r1]++;
            redBalls[r2]++;
            redBalls[r3]++;
            redBalls[r4]++;
            redBalls[r5]++;
            redBalls[r6]++;
            blueBalls[b]++;

            Lottery l(id,rd,r1,r2,r3,r4,r5,r6,b);
            allLottery.push_back(l);
            //cout<<l.toString()<<endl;

        }

        //Display Red Ball
        displayBalls(blueBalls);

        cout<<"\tSort..."<<endl;
        sortBall(blueBalls);

        cout<<"\tDisplay again.."<<endl;
        displayBalls(blueBalls);


    }
    catch (CppSQLite3Exception& e)
    {
        cerr << e.errorCode() << ":" << e.errorMessage() << endl;
    }

    ////////////////////////////////////////////////////////////////
    // Loop until user enters q or Q
    ///////////////////////////////////////////////////////////
    char c(' ');

    do
    {

        cout << "Press q then enter to quit: ";
        cin >> c;
    }while(c != 'q' && c != 'Q');

    return 0;
}

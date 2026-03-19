#include <iostream>
#include "BinManager.h"

using namespace std;

int main()
{
    cout << "*** Inventory Bins in OOP! ***\n\n";

    BinManager binMgr;

    int choice = 0;

    do
    {
        binMgr.print();
        cout << "\nChoose a bin nummber to update, or enter 0 to quit: ";
        cin >> choice;
        while (choice < 0 || choice > binMgr.getNumBins())
        {
            cout << "\nEnter 0 to quit, or choose a bin Number: ";
            cin >> choice;
        }
        if (choice != 0)
        {
            if (!binMgr.updateBin(choice))
            {
                cout << "\nUpdate failed - please try again.\n";
            }
        }
    } while (choice != 0);
    return 0;
}

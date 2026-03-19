#include <iostream>
#include "BinManager.h"

using namespace std;

// Instructions 9 & 10: Default Constructor
BinManager::BinManager() : bin1(10, "Knife Gate Valve"), bin2(5, 'S') // Initialize bin1 and bin2 using their parameterized constructors
{
    // In C++, bin1 and bin2 are already created in memory by this point.
    // We just need to set their initial values using their methods.

    // // Setup bin1 (ValveBin)
    // bin1.setNumParts(10);
    // bin1.setType("Knife Gate Valve");

    // either use their methods to set up the variables of bins or use the parameterized constructor in the signature.

    // // Setup bin2 (GearBin)
    // bin2.setNumParts(5);
    // bin2.setSize('S');

    numBins = 2;
}

// Instruction 11: Blank Destructor
BinManager::~BinManager()
{
}

// Instruction 6: getNumBins
int BinManager::getNumBins() const
{
    return numBins;
}

// Instruction 4: Print method to display all bins
void BinManager::print()
{
    cout << "\n--- Bin 1 ---" << endl;
    bin1.print();
    cout << "--- Bin 2 ---" << endl;
    bin2.print();
}

// Instructions 12, 13, 14: updateBin logic
bool BinManager::updateBin(int binNumber)
{
    bool success = false;
    char choice;

    cout << "Enter A to add parts to the bin or R to remove parts: ";
    cin >> choice;

    if (choice == 'A' || choice == 'a')
    {
        int amount;
        cout << "How many parts would you like to add? ";
        cin >> amount;
        success = addParts(binNumber, amount);
    }
    else if (choice == 'R' || choice == 'r')
    {
        int amount;
        cout << "How many parts would you like to remove? ";
        cin >> amount;
        success = removeParts(binNumber, amount);
    }
    else
    {
        cout << "\n** Error: Invalid choice.\n";
    }

    return success;
}

// Instruction 15: addParts (Transcribed from your image)
bool BinManager::addParts(int binNumber, int numParts)
{
    bool success = false;
    InventoryBin *pBin = nullptr; // Pointer to the parent class

    // Point to the correct bin based on user choice
    switch (binNumber)
    { // if user enters 1, point to bin1, if user enters 2, point to bin2
    case 1:
        pBin = &bin1;
        break;
    case 2:
        pBin = &bin2;
        break;
    }

    if (numParts < 0)
    {
        cout << "\n** Error: number of parts cannot be negative.\n";
    }
    else if (pBin != nullptr) // make sure bin exists
    {
        // Check if adding parts exceeds max capacity
        if (numParts + pBin->getNumParts() > pBin->getMaxParts())
        {
            cout << "\n** Error: bin can only hold a maximum of " << pBin->getMaxParts() << " parts.\n";
        }
        else
        {
            pBin->setNumParts(numParts + pBin->getNumParts());
            success = true;
        }
    }
    return success;
}

// Instruction 16: removeParts (Reverse-engineered from addParts)
bool BinManager::removeParts(int binNumber, int numParts)
{
    bool success = false;
    InventoryBin *pBin = nullptr;

    switch (binNumber)
    {
    case 1:
        pBin = &bin1;
        break;
    case 2:
        pBin = &bin2;
        break;
    }

    if (numParts < 0)
    {
        cout << "\n** Error: number of parts cannot be negative.\n";
    }
    else if (pBin != nullptr)
    {
        // Check if trying to remove more parts than we actually have
        if (pBin->getNumParts() - numParts < 0)
        {
            cout << "\n** Error: cannot remove that many parts. Bin only has " << pBin->getNumParts() << " parts.\n";
        }
        else
        {
            pBin->setNumParts(pBin->getNumParts() - numParts);
            success = true;
        }
    }
    return success;
}
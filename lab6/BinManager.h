#ifndef BINMANAGER_H // These are standard "include guards" to prevent loading the file twice
#define BINMANAGER_H

#include <string>
#include "InventoryBin.h"
#include "GearBin.h"
#include "ValveBin.h"

class BinManager
{
private:
    int numBins;
    ValveBin bin1;
    GearBin bin2;

    bool addParts(int binNum, int numParts);
    bool removeParts(int binNum, int numParts);

public:
    BinManager();
    ~BinManager(); // a destructor, used to delete any dynamically allocated memory when the object is destroyed

    void print();
    bool updateBin(int binNum);
    int getNumBins() const; // const used as this function does not modify any member variables
};

#endif
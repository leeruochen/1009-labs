#include <iostream>
#include "InventoryBin.h"

using namespace std;

InventoryBin::InventoryBin()
{ // default constructor
    partQty = 0;
    maxParts = 0;
}

InventoryBin::InventoryBin(int num)
{ // constructor with parameter
    partQty = num;
    maxParts = 0; // default max parts
}

InventoryBin::~InventoryBin()
{ // destructor
  // No dynamic memory to free in this class, but if there were, we would free it here.
}

string InventoryBin::getPartName()
{
    return partName;
}

int InventoryBin::getNumParts()
{
    return partQty;
}

int InventoryBin::getMaxParts()
{
    return maxParts;
}

void InventoryBin::setNumParts(int num)
{
    partQty = num;
}

void InventoryBin::print()
{
    cout << "Part: " << partName << " | Quantity: " << partQty << endl;
}
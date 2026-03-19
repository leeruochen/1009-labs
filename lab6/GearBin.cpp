#include <iostream>
#include "GearBin.h"

using namespace std;

GearBin::GearBin() : InventoryBin() // default constructor, calls the base class default constructor
{
    gearSize = 'M';    // default gear size
    partName = "Gear"; // set part name for all GearBins
    maxParts = 25;     // set a default max parts for all GearBins
}

GearBin::GearBin(int num, char size) : InventoryBin(num) // constructor with parameters, calls the base class constructor with num
{
    gearSize = size;
    partName = "Gear"; // set part name for all GearBins
    maxParts = 25;     // set a default max parts for all GearBins, this overrides the default maxParts set in the base class constructor
}

GearBin::~GearBin()
{ // destructor
  // No dynamic memory to free in this class, but if there were, we would free it here.
}

char GearBin::getSize()
{
    return gearSize;
}

void GearBin::setSize(char size)
{
    gearSize = size;
}

void GearBin::print()
{
    InventoryBin::print(); // call the base class print to show part name and quantity, then add gear size

    cout << "Gear Size: " << gearSize << endl;
}
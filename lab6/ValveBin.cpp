#include <iostream>
#include "ValveBin.h"

using namespace std;

ValveBin::ValveBin() : InventoryBin() // default constructor, calls the base class default constructor
{
    valveType = "Ball Valve"; // default valve type
    partName = "Valve";       // set part name for all ValveBins
    maxParts = 30;            // set a default max parts for all ValveBins
}

ValveBin::ValveBin(int num, std::string type) : InventoryBin(num) // constructor with parameters, calls the base class constructor with num
{
    valveType = type;
    partName = "Valve"; // set part name for all ValveBins
    maxParts = 30;      // set a default max parts for all ValveBins, this overrides the default maxParts set in the base class constructor
}

ValveBin::~ValveBin()
{ // destructor
  // No dynamic memory to free in this class, but if there were, we would free it here.
}

std::string ValveBin::getType()
{
    return valveType;
}

void ValveBin::setType(std::string type)
{
    valveType = type;
}

void ValveBin::print()
{
    InventoryBin::print(); // call the base class print to show part name and quantity, then add valve type

    std::cout << "Valve Type: " << valveType << std::endl;
}

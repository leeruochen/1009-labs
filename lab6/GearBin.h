#ifndef GEARBIN_H
#define GEARBIN_H

#include "InventoryBin.h"

class GearBin : public InventoryBin // this shows inheritance, instead of GearBin inherits InventoryBin in java, use : to show that GearBin is a subclass of InventoryBin
{
private:
    char gearSize;

public:
    GearBin();
    GearBin(int num, char size);
    ~GearBin();

    char getSize();
    void setSize(char size);

    void print();
};

#endif
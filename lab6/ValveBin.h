#ifndef VALVEBIN_H
#define VALVEBIN_H

#include "InventoryBin.h"
#include <string>

class ValveBin : public InventoryBin
{
private:
    std::string valveType;

public:
    ValveBin();
    ValveBin(int num, std::string type);
    ~ValveBin();

    std::string getType();
    void setType(std::string type);

    void print();
};

#endif
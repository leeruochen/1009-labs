#ifndef INVENTORYBIN_H // These are standard "include guards" to prevent loading the file twice
#define INVENTORYBIN_H

#include <string>

class InventoryBin
{
private:
    int partQty;

protected:
    std::string partName;
    int maxParts;

public:
    InventoryBin();
    InventoryBin(int num);
    ~InventoryBin(); // a destructor, used to delete any dynamically allocated memory when the object is destroyed

    std::string getPartName();
    int getNumParts();
    int getMaxParts();

    void setNumParts(int num);

    void print();
};

#endif
#include <iostream>
#include <string>
#include <vector>

using namespace std;

const int N = 5;

void imprimir(string matriz[N][N]) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cout << matriz[i][j] << "\t";
        }
        cout << endl;
    }
}

int main() {
    string matriz[N][N] = {
        {"Hugo", "Paco", "Luis", "Jesus", "Maria"},
        {"Jose", "Martha", "Ena", "Bertha", "Lula"},
        {"Putin", "Ana", "Luisa", "Jesusa", "Mario"},
        {"Xi", "Fi", "Fu", "Li", "Ju"},
        {"Rena", "Paca", "Leo", "Javier", "Bruno"}
    };

    cout << "\nMATRIZ COMPLETA" << endl;
    imprimir(matriz);

    cout << "\nCONTORNO" << endl;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                cout << matriz[i][j] << "\t";
            } else {
                cout << "   \t";
            }
        }
        cout << endl;
    }

    return 0;
}
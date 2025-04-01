#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Om{
    protected:
    string name;

    public:
    Om(const string &name) : name(name) {}
    void virtual display() const = 0;
    
};

class Doctor : public Om {
    private:
        string speciality;
    public:
        
        Doctor(const string &name, const string &speciality) : Om(name), speciality(speciality) {}
        void display() const override {
            cout << "Doctor: " << name << " Speciality: " << speciality << endl;
        }
    };

class Patient: public Om {
    private:
        vector<string> disease;
    public:
        Patient(const string &name, const vector<string> &disease) : Om(name), disease(disease) {}
        void display() const override {
            cout << "Patient: " << name << " Diseases: ";
            for (const auto &d : disease) {
                cout << d << " ";
            }
            cout << endl;
        }
    };

class Hospital {

    private:
        vector<Doctor> doctors;
        vector<Patient> patients;
    public:
        void addDoctor(string name, string speciality)
        {  
            Doctor doctor = Doctor(name, speciality);
            doctors.push_back(doctor);
        }
        void addPatient(string name, vector<string> disease)
        {
            Patient patient = Patient(name, disease);
            patients.push_back(patient);
        }
    };

int main() {

    Doctor doctor1("Popescu", "Heart");
    Doctor doctor2("Ionescu", "Lung");
    
    cout<<"Doctors: "<<endl;
    doctor1.display();
    doctor2.display();

    cout<<"Patients: "<<endl;
    Patient patient1("Vasile", {"Heart"});
    Patient patient2("George", {"Lung"});
    Patient patient3("Ion", {"Heart", "Lung"});
    
    cout<<"Patients: "<<endl;
    patient1.display(); 
    patient2.display();
    patient3.display();


    return 0;
}
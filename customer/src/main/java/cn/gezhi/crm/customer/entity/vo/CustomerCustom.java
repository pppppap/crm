package cn.gezhi.crm.customer.entity.vo;

import cn.gezhi.crm.customer.entity.Bank;
import cn.gezhi.crm.customer.entity.Car;
import cn.gezhi.crm.customer.entity.Customer;
import cn.gezhi.crm.customer.entity.House;
import cn.gezhi.crm.org.entity.Employee;

import java.util.List;

/**
 * TODO
 *
 * @author pppppap
 */
public class CustomerCustom extends Customer {
    private Bank bank;
    private List<House> houses;
    private List<Car> cars;
    private Employee salesman;
    private Employee evaluteman;


    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public Employee getSalesman() {
        return salesman;
    }

    public void setSalesman(Employee salesman) {
        this.salesman = salesman;
    }

    public Employee getEvaluteman() {
        return evaluteman;
    }

    public void setEvaluteman(Employee evaluteman) {
        this.evaluteman = evaluteman;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CustomerCustom{" +
                "bank=" + bank +
                ", houses=" + houses +
                ", cars=" + cars +
                ", salesman=" + salesman +
                ", evaluteman=" + evaluteman +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", tel='" + tel + '\'' +
                ", loan=" + loan +
                ", bankId=" + bankId +
                ", realloan=" + realloan +
                ", process='" + process + '\'' +
                ", common=" + common +
                ", note='" + note + '\'' +
                ", salesmanId=" + salesmanId +
                ", attentionLevel='" + attentionLevel + '\'' +
                ", evaluteId=" + evaluteId +
                ", customerLevel='" + customerLevel + '\'' +
                ", date=" + date +
                ", securityId='" + securityId + '\'' +
                '}';
    }
}

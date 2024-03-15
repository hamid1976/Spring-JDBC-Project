package com.spring.jdbc;

import com.spring.jdbc.dao.CityDaoImpl;
import com.spring.jdbc.dao.CountryDaoImpl;
import com.spring.jdbc.dao.DivisionDaoImpl;
import com.spring.jdbc.dao.ProvinceDaoImpl;
import com.spring.jdbc.entities.City;
import com.spring.jdbc.entities.Country;
import com.spring.jdbc.entities.Division;
import com.spring.jdbc.entities.Province;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.*;


public class SpringJdbcMini
{
    public static void main( String[] args )
    {
        Scanner ob=new Scanner(System.in);
        System.out.println( "Program Started.............." );

        //Spring JDBC Template
        ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);

        char ch='T';
        do {
            try {
                System.out.println("\n1.Country\n2.Province\n3.Division\n4.City\n5.Exit\nEnter Selection:");
                int mainSel = ob.nextInt();

                if (mainSel == 1) {
                    char d = 'T';
                    do {
                        try {
                            System.out.println("\n1.GetAllCountries\n2.GetCountryNyName\n3.AddCountrie\n4.UpdateCountrie\n5.DeleteCountrie\n6.Back\nEnter Selection:");
                            int countrySel = ob.nextInt();
                            CountryDaoImpl countryDaoImp = (CountryDaoImpl) context.getBean("countryDao", CountryDaoImpl.class);
                            switch (countrySel) {
                                case 1:
                                    List<Country> countries = countryDaoImp.getAll();
                                    System.out.println("\nCountries Name\n");
                                    for (Country s : countries) {
                                        System.out.println(s);
                                    }
                                    System.out.println("--------------GetAllCountries------------------");
                                    break;
                                case 2:
                                    System.out.println("Enter Country Name");
                                    String add = ob.next();
                                    Country c1 = countryDaoImp.get(add);
                                    System.out.println(c1);
                                    System.out.println("-------------GetCountrieByName------------------");
                                    break;
                                case 3:
                                    Country country = new Country();
                                    System.out.println("Enter Country Name");
                                    String add1 = ob.next();
                                    country.setCountryName(add1);
                                    int result = countryDaoImp.insert(country);

                                    System.out.println("Country Added Successfully:");
                                    System.out.println("-------------- AddCountrie-----------------------");
                                    break;
                                case 4:
                                    Country country2 = new Country();
                                    System.out.println("Enter Country Name Which You want to update:");
                                    String s = ob.next();

                                    System.out.println("Enter New Country Name Which You want to update:");
                                    String s1 = ob.next();

                                    country2.setCountryName(s);
                                    country2.setCountryName(s1);

                                    int result1 = countryDaoImp.change(country2);
                                    if (result1 > 0) {
                                        System.out.println("Country Updated Successfully");
                                    } else {
                                        System.out.println("Country Updation  Failed");
                                    }

                                    System.out.println("-----------------UpdateCountrie------------------");
                                    break;
                                case 5:
                                    System.out.println("Enter Country Name Which u want to delete:");
                                    String name = ob.next();
                                    int result2 = countryDaoImp.delete(name);

                                    if (result2 > 0) {
                                        System.out.println("Country Deleted Successfully");
                                    } else {
                                        System.out.println("Country Deletion  Failed");
                                    }

                                    System.out.println("---------------DeleteCountrie--------------------");
                                    break;
                                case 6:
                                    d = 'F';
                                    break;
                                default:
                                    System.out.println("Invalid Selection");
                                    break;
                            }//end switch
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Input MisMatch\n");
                            ob.nextLine(); // Consume the invalid input
                        }
                    } while (d == 'T');
                }//end if mainSel:1 country


                if (mainSel == 2) {
                    char e = 'T';
                    do {
                        try {
                            System.out.println("\n1.GetAllProvince\n2.GetProvinceByName\n3.AddProvince\n4.UpdateProvince\n5.DeleteProvince\n6.Back\nEnter Selection:");
                            int provinceSel = ob.nextInt();
                            ProvinceDaoImpl provinceDaoImp = (ProvinceDaoImpl) context.getBean("provinceDao", ProvinceDaoImpl.class);
                            switch (provinceSel) {
                                case 1:
                                    List<Province> province = provinceDaoImp.getAll();
                                    System.out.println("\nProvince Name\t\t\tCountry Name\n");
                                    for (Province s : province) {
                                        System.out.println(s);
                                    }
                                    System.out.println("------------GetAllProvince------------------");
                                    break;
                                case 2:
                                    System.out.println("Enter Province Name");
                                    String add = ob.next();
                                    Province c1 = provinceDaoImp.get(add);
                                    System.out.println(c1);
                                    System.out.println("-----------GetByProvinceName------------------");
                                    break;
                                case 3:
                                    Province province1 = new Province();
                                    System.out.println("Enter Province Name Which You want to add:");
                                    String add1 = ob.next();
                                    System.out.println("Enter Country Name FK Which You want to add:");
                                    String add2 = ob.next();
                                    province1.setProvinceName(add1);
                                    province1.setCountryName(add2);
                                    int result = provinceDaoImp.insert(province1);

                                    if (result > 0) {
                                        System.out.println("Province Added Successfully");
                                    } else {
                                        System.out.println("Province  Addition Failed");
                                    }

                                    System.out.println("------------AddProvince-------------------");
                                    break;
                                case 4:
                                    Province province2 = new Province();

                                    System.out.println("Enter New Province Name:");
                                    String newProvinceName = ob.next();

                                    System.out.println("Enter Country Name:");
                                    String newCountryName = ob.next();

                                    province2.setProvinceName(newProvinceName);
                                    province2.setCountryName(newCountryName);

                                    int result1 = provinceDaoImp.change(province2);

                                    if (result1 > 0) {
                                        System.out.println("Province Updated Successfully");
                                    } else {
                                        System.out.println("Failed to update province");
                                    }

                                    break;
                                case 5:
                                    System.out.println("Enter Province Name Which u want to delete:");
                                    String name = ob.next();
                                    int result2 = provinceDaoImp.delete(name);


                                    if (result2 > 0) {
                                        System.out.println("Province Deleted Successfully");
                                    } else {
                                        System.out.println("Province Deletion  Failed");
                                    }
                                    System.out.println("-------------DeleteProvince------------------");
                                    break;
                                case 6:
                                    e = 'F';
                                    break;
                                default:
                                    System.out.println("Invalid Selection");
                                    break;
                            }//end switch
                        } catch (Exception h) {
                            h.printStackTrace();
                            System.out.println("Input MisMatch\n");
                            ob.nextLine(); // Consume the invalid input
                        }
                    } while (e == 'T');
                }//end if mainSel:2 province


                if (mainSel == 3) {
                    char f = 'T';
                    do {
                        try {
                            System.out.println("\n1.getAllDivision\n2.getDivisionByName\n3.AddDivision\n4.UpdateDivision\n5.DeleteDivision\n6.Back\nEnter Selection:");
                            int divisionSel = ob.nextInt();
                            DivisionDaoImpl divisionDaoImpl = (DivisionDaoImpl) context.getBean("divisionDao", DivisionDaoImpl.class);
                            switch (divisionSel) {
                                case 1:
                                    List<Division> division = divisionDaoImpl.getAll();
                                    System.out.println("\nDivision Name\t\t\tProvince Name\n");
                                    for (Division s : division) {
                                        System.out.println(s);
                                    }
                                    System.out.println("-------------GetAllDivisions--------------");
                                    break;
                                case 2:
                                    System.out.println("Enter DivisionName Which You Want to get");
                                    ob.nextLine();
                                    String add = ob.nextLine();

                                    Division c1 = divisionDaoImpl.get(add);
                                    System.out.println(c1);
                                    System.out.println("--------------GetDivisionByName------------");
                                    break;
                                case 3:
                                    Division division1 = new Division();
                                    System.out.println("Enter Division Name Which You want to add:");
                                    ob.nextLine();
                                    String add1 = ob.nextLine();
                                    System.out.println("Enter Province Name FK Which You want to add:");
                                    String add2 = ob.next();
                                    division1.setDivisionName(add1);
                                    division1.setProvincName(add2);
                                    int result = divisionDaoImpl.insert(division1);

                                    System.out.println("Divison Added Successfully:");
                                    break;
                                case 4:
                                    Division division2 = new Division();

                                    System.out.println("Enter New Division Name:");
                                    ob.nextLine();
                                    String add3 = ob.nextLine();
                                    System.out.println("Enter Province Name:");
                                    String add4 = ob.next();
                                    division2.setDivisionName(add3);
                                    division2.setProvincName(add4);

                                    int result1 = divisionDaoImpl.change(division2);

                                    if (result1 > 0) {
                                        System.out.println("Division Updated Successfully");
                                    } else {
                                        System.out.println("Failed to update division");
                                    }
                                    break;
                                case 5:
                                    System.out.println("Enter Division Name Which u want to delete:");
                                    ob.nextLine();
                                    String name = ob.nextLine();
                                    int result2 = divisionDaoImpl.delete(name);
                                    System.out.println("Division Deleted Successfully:");


                                    if (result2 > 0) {
                                        System.out.println("Division Deleted Successfully");
                                    } else {
                                        System.out.println("Division Deletion  Failed");
                                    }

                                    break;
                                case 6:
                                    f = 'F';
                                    break;
                                default:
                                    System.out.println("Invalid Selection");
                                    break;
                            }//end switch
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Input MisMatch\n");
                            ob.nextLine(); // Consume the invalid input
                        }
                    } while (f == 'T');
                }//end if mainSel:3 division

                if (mainSel == 4) {
                    char c = 'T';
                    do {
                        try {
                            System.out.println("\n1.getAllCities\n2.getCityByName\n3.AddCity\n4.UpdateCity\n5.DeleteCity\n6.Back\nEnter Selection:");
                            int citySel = ob.nextInt();
                            CityDaoImpl cityDaoImpl = (CityDaoImpl) context.getBean("cityDao", CityDaoImpl.class);
                            switch (citySel) {
                                case 1:
                                    List<City> city = cityDaoImpl.getAll();
                                    System.out.println("\nCity\t\tDivision Name\t\tLongitude\t\tLongitude");
                                    for (City s : city) {
                                        System.out.println(s);
                                    }
                                    break;
                                case 2:
                                    System.out.println("Enter City Detail Which You Want to get");
                                    ob.nextLine();
                                    String add = ob.nextLine();
                                    City c1 = cityDaoImpl.get(add);
                                    System.out.println(c1);
                                    System.out.println("-------------GetCityByName--------------");
                                    break;
                                case 3:
                                    City city1 = new City();

                                    System.out.println("Enter City Name Which You want to add:");
                                    ob.nextLine();
                                    String add1 = ob.nextLine();
                                    city1.setCityName(add1);

                                    System.out.println("Enter Division Name FK Which You want to add:");
                                    String add2 = ob.nextLine();
                                    city1.setDivisonName(add2);

                                    System.out.println("Enter Longitude Which You want to add:");
                                    String add3 = ob.nextLine();

                                    System.out.println("Enter Latitude Which You want to add:");
                                    String add4 = ob.nextLine();
                                    city1.setLatitude(add4);

                                    int result = cityDaoImpl.insert(city1);

                                    System.out.println("City Added Successfully:");
                                    break;
                                case 4:
                                    City city2 = new City();

                                    System.out.println("Enter City Name Which You Want to Update :");
                                    ob.nextLine();
                                    String cityName = ob.nextLine();

                                    System.out.println("Enter Division Name:");
                                    String divisionName = ob.nextLine();

                                    System.out.println("Enter Longitude:");
                                    String longitude = ob.next();

                                    System.out.println("Enter Latitude:");
                                    String latitude = ob.next();

                                    city2.setCityName(cityName);
                                    city2.setDivisonName(divisionName);
                                    city2.setLongitude(longitude);
                                    city2.setLatitude(latitude);

                                    int result1 = cityDaoImpl.change(city2);

                                    if (result1 > 0) {
                                        System.out.println("City Updated Successfully");
                                    } else {
                                        System.out.println("City  Update  Failed");
                                    }

                                    break;
                                case 5:
                                    System.out.println("Enter City Name Which u want to delete:");
                                    ob.nextLine();
                                    String name = ob.nextLine();
                                    int result2 = cityDaoImpl.delete(name);
                                    System.out.println("City Deleted Successfully:");


                                    if (result2 > 0) {
                                        System.out.println("City Deleted Successfully");
                                    } else {
                                        System.out.println("City Deletion  Failed");
                                    }

                                    break;
                                case 6:
                                    c = 'F';
                                    break;
                                default:
                                    System.out.println("Invalid Selection");
                                    break;
                            }//end switch
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Input MisMatch\n");
                            ob.nextLine(); // Consume the invalid input
                        }
                    } while (c == 'T');
                }//end if mainSel:4 City

                if (mainSel == 5) {
                    System.out.println("Good Bye");
                    System.exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Input MisMatch\n");
                ob.nextLine(); // Consume the invalid input
            }
        }while (ch=='T');




    }
}

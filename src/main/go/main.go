package main

import (
	"encoding/json"
	"flag"
	"fmt"
	"log"
	"os"
	"runtime"
	"strconv"
	"time"
)

type Employee struct {
	Name string
	Age  int
}
type Printable interface {
	Print()
}

func (e Employee) NameAge(separator string) string {
	return e.Name + separator + strconv.Itoa(e.Age)
}

func (e Employee) Print() {
	fmt.Println(e.NameAge(" "))
}

func init() {
	fmt.Println("..............")
}

var (
	home   = os.Getenv("HOME")
	user   = os.Getenv("USER")
	gopath = os.Getenv("GOPATH")
)

func init() {
	log.Println("Testing....")
	if user == "" {
		log.Fatal("$USER not set")
	}
	if home == "" {
		home = "/home/" + user
	}
	if gopath == "" {
		gopath = home + "/go"
	}
	// gopath may be overridden by --gopath flag on command line.
	flag.StringVar(&gopath, "gopath", gopath, "override default GOPATH")
}

func main() {
	defer fmt.Println("Hello", home, ":", gopath, ":", user)
	var e Printable = Employee{"Hasari", 50}
	e.Print()

	primes := [6]int{2, 3, 5, 7, 11, 13}

	var newList []int = append(primes[:], 5)
	fmt.Println(newList)

	var s []int = primes[1:4]
	fmt.Println(s)

	ss := []struct {
		i int
		b bool
	}{
		{2, true},
		{3, false},
		{5, true},
		{7, true},
		{11, false},
		{13, true},
	}
	fmt.Println(ss)
	DisplayOS()

	hosts := map[string]IPAddr{
		"loopback":  {127, 0, 0, 1},
		"googleDNS": {8, 8, 8, 8},
	}
	for name, ip := range hosts {
		fmt.Printf("%v: %v\n", name, ip)
	}
	fmt.Println("----------------------------------------------\n\n")
	go say("world")
	say("hello")
	time.Sleep(12000)
	fmt.Println("----------------------------------------------\n\n")

	data := []byte(`{
		"id": 1,
		"name": "Tit Petric",
		"address": {
			"street": "Viska cesta 49c",
			"zip": "1000",
			"city": "Ljubljana",
			"country": "Slovenia"
		}
	}`)

	var person Person

	err := json.Unmarshal(data, &person)
	if err == nil {
		data, _ := json.Marshal(person)
		fmt.Println(string(data))
	}

}

func say(s string) {
	for i := 0; i < 5; i++ {
		time.Sleep(100 * time.Millisecond)
		fmt.Println(s)
	}
}

type IPAddr [4]byte

// TODO: Add a "String() string" method to IPAddr.
func (ip IPAddr) String() string {
	//fmt.Println(strings.Join(ip, "."))
	return "" //return strings.Join(ip[:], ".")
}

func DisplayOS() {
	fmt.Print("Go runs on ")
	switch os := runtime.GOOS; os {
	case "darwin":
		fmt.Println("OS X.")
	case "linux":
		fmt.Println("Linux.")
	default:
		// freebsd, openbsd,
		// plan9, windows...
		fmt.Printf("%s.\n", os)
	}
}

type Person struct {
	Id      int    `json:"id"`
	Name    string `json:"name"`
	Address struct {
		City    string `json:"city"`
		Country string `json:"country"`
	} `json:"address"`
}

package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
	"strconv"
	"strings"
	"time"
)

func guess() {
	reader := bufio.NewReader(os.Stdin)

	seed := rand.NewSource(time.Now().UnixNano())
	randx := rand.New(seed)

	secret := randx.Intn(100)

	var guessedCorrectly = false

	for i := 0; i < 6; i++ {
		fmt.Println("Guess a number in range of 0-100 >")
		num_str, _ := reader.ReadString('\n')
		number, err := strconv.Atoi(strings.TrimSpace(num_str))

		if err != nil {
			fmt.Println("Bad number entered...", num_str, " Err:", err)
			break
		}
		if number == secret {
			fmt.Println("Guessed correctly:", secret)
			guessedCorrectly = true
			break
		} else if number < secret {
			fmt.Println("More...")
		} else {
			fmt.Println("Less...")
		}
	}
	if !guessedCorrectly {
		fmt.Println("Try harder next time...")
	}
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	fmt.Println("Welcome to number guessing game...")
	fmt.Print("Enter Y to start")
	text, _ := reader.ReadString('\n')
	if strings.TrimRight(text, "\n") == "Y" {
		fmt.Println("Starting the game...")
		guess()
	} else {
		fmt.Println("Thanks...")
	}
}

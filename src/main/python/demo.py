import random

# arrays or list
pronouns = ["he", "she", "I", "it"]
nouns = ["cat", "dog", "bird", "mountain", "tree", "river"]
verbs = ["called", "ran", "flew", "ate", "fell", "drank", "talk"]
adjectives = ["yellow", "lazy", "fat", "smart", "small", "large"]
adverbs = ["slowly", "quickly", "fast", "hard", "softly"]

def pick_from_list(list):
    index = random.randrange(len(list))
    return list[index]


def generate_sentence():
    adjective = pick_from_list(adjectives)
    verb = pick_from_list(verbs)
    r = random.random()
    is_pronoun = False
    if r < 1 / 3:
        noun = pick_from_list(pronouns)
        is_pronoun = True
    else:
        noun = pick_from_list(nouns)

    adverb = pick_from_list(adverbs)

    r = random.random()
    if r < 1 / 3:

        if not is_pronoun:
            sentence = noun + " " + verb + " " + adverb
        else:
            sentence = "The " + adjective + " " + noun + " " + verb + " " + adverb
    else:
        sentence = noun + " " + verb + " " + adverb

    return sentence


def generate_paragraph(min, max):
    text = ""
    number_sentence = random.randrange(min, max + 1)

    for i in range(0, number_sentence, 2):
        sentence1 = generate_sentence()
        sentence2 = generate_sentence()

        r = random.random()

        if r < 1 / 3.0:
            text = text + sentence1.capitalize() + " and " + sentence2 + ". "
        else:
            text = text + sentence1.capitalize() + ". " + sentence2.capitalize() + ". "

    return text


def generate_document(min, max):
    text = ""
    number = random.randrange(min, max + 1)
    for i in range(number):
        p = generate_paragraph(7, 15)
        text = text + p + "\n\n"
    return text


if __name__ == "__main__":
    p = generate_document(10, 15)
    print(p)
    # for i in range(100):
    #     sentence = generate_sentence()
    #     print(sentence)

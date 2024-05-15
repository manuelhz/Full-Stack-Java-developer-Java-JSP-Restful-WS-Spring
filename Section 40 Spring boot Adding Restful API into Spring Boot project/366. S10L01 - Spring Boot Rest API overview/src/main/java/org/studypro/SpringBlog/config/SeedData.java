package org.studypro.SpringBlog.config;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.studypro.SpringBlog.models.Account;
import org.studypro.SpringBlog.models.Authority;
import org.studypro.SpringBlog.models.Post;
import org.studypro.SpringBlog.services.AccountService;
import org.studypro.SpringBlog.services.AuthorityService;
import org.studypro.SpringBlog.services.PostService;
import org.studypro.SpringBlog.util.constants.Privileges;
import org.studypro.SpringBlog.util.constants.Roles;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        for(Privileges auth: Privileges.values()) {
            Authority authority = new Authority();
            authority.setAuthorityId(auth.getId());
            authority.setName(auth.getPrivilege());
            authorityService.save(authority);
        }

        Account account01 = new Account();
        Account account02 = new Account();
        Account account03 = new Account();
        Account account04 = new Account();

        // account01.setEmail("user@studypro.org");
        // account01.setPassword("password01");

        account01.setEmail("mhernandez80@gmail.com");
        account01.setPassword("123");
        
        account01.setFirstName("User");
        account01.setLastName("Lastname01");
        account01.setAge(21);
        account01.setDateOfBirth(LocalDate.parse("1991-01-01"));
        account01.setGender("Male");

        account02.setEmail("admin@studypro.org");
        account02.setPassword("password02");
        account02.setFirstName("Admin");
        account02.setLastName("lastname02");
        account02.setRole(Roles.ADMIN.getRole());
        account02.setAge(21);
        account02.setDateOfBirth(LocalDate.parse("1992-01-01"));
        account02.setGender("Female");

        account03.setEmail("editor@studypro.org");
        account03.setPassword("password03");
        account03.setFirstName("Editor");
        account03.setLastName("lastname03");
        account03.setRole(Roles.EDITOR.getRole());
        account03.setAge(22);
        account03.setDateOfBirth(LocalDate.parse("1993-01-01"));
        account03.setGender("Others");

        account04.setEmail("supereditor@studypro.org");
        account04.setPassword("password04");
        account04.setFirstName("Supereditor");
        account04.setLastName("lastname04");
        account04.setRole(Roles.EDITOR.getRole());
        account04.setAge(24);
        account04.setDateOfBirth(LocalDate.parse("1994-01-01"));
        account04.setGender("Male");
        Set<Authority> authoties = new HashSet<>();
        authorityService.findById(Privileges.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authoties::add);
        authorityService.findById(Privileges.ACCESS_ADMIN_PANEL.getId()).ifPresent(authoties::add);
        account04.setAuthorities(authoties);

        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);


        List<Post> posts = postService.findAll();

        
        if (posts.size() == 0) {

            Post post01 = new Post();
            post01.setTitle("About Git");
            post01.setBody("""
                Git (/ɡɪt/)[8] is a distributed version control system[9] that tracks changes in any set of computer files, usually used for coordinating work among programmers who are collaboratively developing source code during software development. Its goals include speed, data integrity, and support for distributed, non-linear workflows (thousands of parallel branches running on different computers).[10][11][12]

Git was originally authored by Linus Torvalds in 2005 for development of the Linux kernel, with other kernel developers contributing to its initial development.[13] Since 2005, Junio Hamano has been the core maintainer. As with most other distributed version control systems, and unlike most client–server systems, every Git directory on every computer is a full-fledged repository with complete history and full version-tracking abilities, independent of network access or a central server.[14] Git is free and open-source software shared under the GPL-2.0-only license.

Since its creation, Git has become the most popular distributed version control system, with nearly 95% of developers reporting it as their primary version control system as of 2022.[15] There are many popular offerings of Git repository services, including GitHub, SourceForge, Bitbucket and GitLab.[16][17][18][19][20] 
            """);
            

            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Model–view–controller");
            post02.setBody("""
                Model–view–controller (MVC) is a software design pattern[1] commonly used for developing user interfaces that divides the related program logic into three interconnected elements. These elements are the internal representations of information (the model), the interface (the view) that presents information to and accepts it from the user, and the controller software linking the two.[2][3]

            Traditionally used for desktop graphical user interfaces (GUIs), this pattern became popular for designing web applications.[4] Popular programming languages have MVC frameworks that facilitate the implementation of the pattern. 
            """);
            post02.setAccount(account02);
            postService.save(post02);

            Post post03 = new Post();
            post03.setTitle("Linux");
            post03.setBody("""
                Linux (/ˈlɪnʊks/ LIN-uuks)[11] is a family of open-source Unix-like operating systems based on the Linux kernel,[12] an operating system kernel first released on September 17, 1991, by Linus Torvalds.[13][14][15] Linux is typically packaged as a Linux distribution (distro), which includes the kernel and supporting system software and libraries, many of which are provided by the GNU Project. Many Linux distributions use the word "Linux" in their name, but the Free Software Foundation uses and recommends the name "GNU/Linux" to emphasize the use and importance of GNU software in many distributions, causing some controversy.[16][17]

                Popular Linux distributions[18][19][20] include Debian, Fedora Linux, Arch Linux, and Ubuntu. Commercial distributions include Red Hat Enterprise Linux and SUSE Linux Enterprise. Desktop Linux distributions include a windowing system such as X11 or Wayland and a desktop environment such as GNOME or KDE Plasma. Distributions intended for servers may not have a graphical user interface at all, or include a solution stack such as LAMP. Because Linux is freely redistributable, anyone may create a distribution for any purpose.[21]
                
                Linux was originally developed for personal computers based on the Intel x86 architecture, but has since been ported to more platforms than any other operating system.[22] Because of the dominance of Linux-based Android on smartphones, Linux, including Android, has the largest installed base of all general-purpose operating systems as of May 2022.[23][24][25] Although Linux is, as of November 2022, used by only around 2.6 percent of desktop computers,[26] the Chromebook, which runs the Linux kernel-based ChromeOS, dominates the US K–12 education market and represents nearly 20 percent of sub-$300 notebook sales in the US.[27] Linux is the leading operating system on servers (over 96.4% of the top one million web servers' operating systems are Linux),[28] leads other big iron systems such as mainframe computers, and is used on all of the world's 500 fastest supercomputers[d] (as of November 2017, having gradually displaced all competitors).[29][30][31]
                
                Linux also runs on embedded systems, i.e., devices whose operating system is typically built into the firmware and is highly tailored to the system. This includes routers, automation controls, smart home devices, video game consoles,[32] televisions (Samsung and LG Smart TVs),[33][34][35] automobiles (Tesla, Audi, Mercedes-Benz, Hyundai, and Toyota),[36] and spacecraft (Falcon 9 rocket, Dragon crew capsule, and the Perseverance rover).[37][38]
                
                Linux is one of the most prominent examples of free and open-source software collaboration. The source code may be used, modified, and distributed commercially or non-commercially by anyone under the terms of its respective licenses, such as the GNU General Public License (GPL). The Linux kernel, for example, is licensed under the GPLv2, with an exception for system calls that allows code that calls the kernel via system calls not to be licensed under the GPL.[39][40][21]
                History
                Main article: History of Linux
                Precursors
                Linus Torvalds, principal author of the Linux kernel
                
                The Unix operating system was conceived and implemented in 1969, at AT&T's Bell Labs, in the United States by Ken Thompson, Dennis Ritchie, Douglas McIlroy, and Joe Ossanna.[41] First released in 1971, Unix was written entirely in assembly language, as was common practice at the time. In 1973, in a key pioneering approach, it was rewritten in the C programming language by Dennis Ritchie (with the exception of some hardware and I/O routines). The availability of a high-level language implementation of Unix made its porting to different computer platforms easier.[42]
                
                Due to an earlier antitrust case[specify] forbidding it[specify] from entering the computer business, AT&T licensed the operating system's source code as a trade secret to anyone who asked.[clarification needed] As a result, Unix grew quickly and became widely adopted by academic institutions and businesses. In 1984, AT&T divested itself of its regional operating companies, and was released from its obligation not to enter the computer business; freed of that obligation, Bell Labs began selling Unix as a proprietary product, where users were not legally allowed to modify it.[43][44]
                
                Onyx Systems began selling early microcomputer-based Unix workstations in 1980. Later, Sun Microsystems, founded as a spin-off of a student project at Stanford University, also began selling Unix-based desktop workstations in 1982. While Sun workstations did not use commodity PC hardware, for which Linux was later originally developed, it represented the first successful commercial attempt at distributing a primarily single-user microcomputer that ran a Unix operating system.[45][46]
                
                With Unix increasingly "locked in" as a proprietary product, the GNU Project, started in 1983 by Richard Stallman, had the goal of creating a "complete Unix-compatible software system" composed entirely of free software. Work began in 1984.[47] Later, in 1985, Stallman started the Free Software Foundation and wrote the GNU General Public License (GNU GPL) in 1989. By the early 1990s, many of the programs required in an operating system (such as libraries, compilers, text editors, a command-line shell, and a windowing system) were completed, although low-level elements such as device drivers, daemons, and the kernel, called GNU Hurd, were stalled and incomplete.[48]
                
                MINIX was created by Andrew S. Tanenbaum, a computer science professor, and released in 1987 as a minimal Unix-like operating system targeted at students and others who wanted to learn operating system principles. Although the complete source code of MINIX was freely available, the licensing terms prevented it from being free software until the licensing changed in April 2000.[49]
                
                Although not released until 1992, due to legal complications, development of 386BSD, from which NetBSD, OpenBSD and FreeBSD descended, predated that of Linux. Linus Torvalds has stated on separate occasions that if the GNU kernel or 386BSD had been available at the time (1991), he probably would not have created Linux.[50][51]
                Creation
                
                While attending the University of Helsinki in the fall of 1990, Torvalds enrolled in a Unix course.[52] The course used a MicroVAX minicomputer running Ultrix, and one of the required texts was Operating Systems: Design and Implementation by Andrew S. Tanenbaum. This textbook included a copy of Tanenbaum's MINIX operating system. It was with this course that Torvalds first became exposed to Unix. In 1991, he became curious about operating systems.[53] Frustrated by the licensing of MINIX, which at the time limited it to educational use only,[49] he began to work on his own operating system kernel, which eventually became the Linux kernel.
                
                On July 3, 1991, in an effort to implement Unix system calls, Linus Torvalds attempted unsuccessfully to obtain a digital copy of the POSIX standards documentation with a request to the comp.os.minix newsgroup.[54] After not finding the POSIX documentation, Torvalds initially resorted to determining system calls from SunOS documentation owned by the university for use in operating its Sun Microsystems server. He also learned some system calls from Tanenbaum's MINIX text.
                
                Torvalds began the development of the Linux kernel on MINIX and applications written for MINIX were also used on Linux. Later, Linux matured and further Linux kernel development took place on Linux systems.[55] GNU applications also replaced all MINIX components, because it was advantageous to use the freely available code from the GNU Project with the fledgling operating system; code licensed under the GNU GPL can be reused in other computer programs as long as they also are released under the same or a compatible license. Torvalds initiated a switch from his original license, which prohibited commercial redistribution, to the GNU GPL.[56] Developers worked to integrate GNU components with the Linux kernel, creating a fully functional and free operating system.[57]
                Naming
                5.25-inch floppy disks holding a very early version of Linux
                
                Linus Torvalds had wanted to call his invention "Freax", a portmanteau of "free", "freak", and "x" (as an allusion to Unix). During the start of his work on the system, some of the project's makefiles included the name "Freax" for about half a year. Initially, Torvalds considered the name "Linux" but dismissed it as too egotistical.[58]
                
                To facilitate development, the files were uploaded to the FTP server (ftp.funet.fi) of FUNET in September 1991. Ari Lemmke, Torvalds' coworker at the Helsinki University of Technology (HUT) who was one of the volunteer administrators for the FTP server at the time, did not think that "Freax" was a good name, so he named the project "Linux" on the server without consulting Torvalds.[58] Later, however, Torvalds consented to "Linux".
                
                According to a newsgroup post by Torvalds,[11] the word "Linux" should be pronounced (/ˈlɪnʊks/ ⓘ LIN-uuks) with a short 'i' as in 'print' and 'u' as in 'put'. To further demonstrate how the word "Linux" should be pronounced, he included an audio guide with the kernel source code.[59] However, in this recording, he pronounces Linux as /ˈlinʊks/ (LEEN-uuks) with a short but close front unrounded vowel, instead of a near-close near-front unrounded vowel as in his newsgroup post.
                Commercial and popular uptake
                Main article: Linux adoption
                Ubuntu, a popular Linux distribution
                Nexus 5X running Android
                
                Adoption of Linux in production environments, rather than being used only by hobbyists, started to take off first in the mid-1990s in the supercomputing community, where organizations such as NASA started to replace their increasingly expensive machines with clusters of inexpensive commodity computers running Linux. Commercial use began when Dell and IBM, followed by Hewlett-Packard, started offering Linux support to escape Microsoft's monopoly in the desktop operating system market.[60]
                
                Today, Linux systems are used throughout computing, from embedded systems to virtually all supercomputers,[31][61] and have secured a place in server installations such as the popular LAMP application stack. Use of Linux distributions in home and enterprise desktops has been growing.[62][63][64][65][66][67][68] Linux distributions have also become popular in the netbook market, with many devices shipping with customized Linux distributions installed, and Google releasing their own ChromeOS designed for netbooks.
                
                Linux's greatest success in the consumer market is perhaps the mobile device market, with Android being the dominant operating system on smartphones and very popular on tablets and, more recently, on wearables. Linux gaming is also on the rise with Valve showing its support for Linux and rolling out SteamOS, its own gaming-oriented Linux distribution, which was later implemented in their Steam Deck platform. Linux distributions have also gained popularity with various local and national governments, such as the federal government of Brazil.[69]
                Current development
                In-flight entertainment system booting up displaying the Linux logo
                
                Linus Torvalds is the lead maintainer for the Linux kernel and guides its development, while Greg Kroah-Hartman is the lead maintainer for the stable branch.[70] Zoë Kooyman is the executive director of the Free Software Foundation,[71] which in turn supports the GNU components.[72] Finally, individuals and corporations develop third-party non-GNU components. These third-party components comprise a vast body of work and may include both kernel modules and user applications and libraries.
                
                Linux vendors and communities combine and distribute the kernel, GNU components, and non-GNU components, with additional package management software in the form of Linux distributions.
                Design
                See also: Linux kernel § Architecture and features
                
                Many open source developers agree that the Linux kernel was not designed but rather evolved through natural selection. Torvalds considers that although the design of Unix served as a scaffolding, "Linux grew with a lot of mutations – and because the mutations were less than random, they were faster and more directed than alpha-particles in DNA."[73] Eric S. Raymond considers Linux's revolutionary aspects to be social, not technical: before Linux, complex software was designed carefully by small groups, but "Linux evolved in a completely different way. From nearly the beginning, it was rather casually hacked on by huge numbers of volunteers coordinating only through the Internet. Quality was maintained not by rigid standards or autocracy but by the naively simple strategy of releasing every week and getting feedback from hundreds of users within days, creating a sort of rapid Darwinian selection on the mutations introduced by developers."[74] Bryan Cantrill, an engineer of a competing OS, agrees that "Linux wasn't designed, it evolved", but considers this to be a limitation, proposing that some features, especially those related to security,[75] cannot be evolved into, "this is not a biological system at the end of the day, it's a software system."[76]
                
                A Linux-based system is a modular Unix-like operating system, deriving much of its basic design from principles established in Unix during the 1970s and 1980s. Such a system uses a monolithic kernel, the Linux kernel, which handles process control, networking, access to the peripherals, and file systems. Device drivers are either integrated directly with the kernel, or added as modules that are loaded while the system is running.[77]
                
                The GNU userland is a key part of most systems based on the Linux kernel, with Android being the notable exception. The GNU C library, an implementation of the C standard library, works as a wrapper for the system calls of the Linux kernel necessary to the kernel-userspace interface, the toolchain is a broad collection of programming tools vital to Linux development (including the compilers used to build the Linux kernel itself), and the coreutils implement many basic Unix tools. The GNU Project also develops Bash, a popular CLI shell. The graphical user interface (or GUI) used by most Linux systems is built on top of an implementation of the X Window System.[78] More recently, the Linux community seeks to advance to Wayland as the new display server protocol in place of X11. Many other open-source software projects contribute to Linux systems.
                Various layers within Linux, also showing separation between the userland and kernel space User mode 	User applications 	bash, LibreOffice, GIMP, Blender, 0 A.D., Mozilla Firefox, ...
                System components 	init daemon:
                OpenRC, runit, systemd... 	System daemons:
                polkitd, smbd, sshd, udevd... 	Window manager:
                X11, Wayland, SurfaceFlinger (Android) 	Graphics:
                Mesa, AMD Catalyst, ... 	Other libraries:
                GTK, Qt, EFL, SDL, SFML, FLTK, GNUstep, ...
                C standard library 	fopen, execv, malloc, memcpy, localtime, pthread_create... (up to 2000 subroutines)
                glibc aims to be fast, musl aims to be lightweight, uClibc targets embedded systems, bionic was written for Android, etc. All aim to be POSIX/SUS-compatible.
                Kernel mode 	Linux kernel 	stat, splice, dup, read, open, ioctl, write, mmap, close, exit, etc. (about 380 system calls)
                The Linux kernel System Call Interface (SCI), aims to be POSIX/SUS-compatible[79]
                Process scheduling subsystem 	IPC subsystem 	Memory management subsystem 	Virtual files subsystem 	Networking subsystem
                Other components: ALSA, DRI, evdev, klibc, LVM, device mapper, Linux Network Scheduler, Netfilter
                Linux Security Modules: SELinux, TOMOYO, AppArmor, Smack
                Hardware (CPU, main memory, data storage devices, etc.)
                
                Installed components of a Linux system include the following:[78][80]
                
                    A bootloader, for example GNU GRUB, LILO, SYSLINUX or systemd-boot. This is a program that loads the Linux kernel into the computer's main memory, by being executed by the computer when it is turned on and after the firmware initialization is performed.
                    An init program, such as the traditional sysvinit and the newer systemd, OpenRC and Upstart. This is the first process launched by the Linux kernel, and is at the root of the process tree. It starts processes such as system services and login prompts (whether graphical or in terminal mode).
                    Software libraries, which contain code that can be used by running processes. On Linux systems using ELF-format executable files, the dynamic linker that manages the use of dynamic libraries is known as ld-linux.so. If the system is set up for the user to compile software themselves, header files will also be included to describe the programming interface of installed libraries. Besides the most commonly used software library on Linux systems, the GNU C Library (glibc), there are numerous other libraries, such as SDL and Mesa.
                        The C standard library is the library necessary to run programs written in C on a computer system, with the GNU C Library being the standard. It provides an implementation of the POSIX API, as well as extensions to that API. For embedded systems, alternatives such as musl, EGLIBC (a glibc fork once used by Debian) and uClibc (which was designed for uClinux) have been developed, although the last two are no longer maintained. Android uses its own C library, Bionic. However, musl can additionally be used as a replacement for glibc on desktop and laptop systems, as seen on certain Linux distributions like Void Linux.
                    Basic Unix commands, with GNU coreutils being the standard implementation. Alternatives exist for embedded systems, such as the copyleft BusyBox, and the BSD-licensed Toybox.
                    Widget toolkits are the libraries used to build graphical user interfaces (GUIs) for software applications. Numerous widget toolkits are available, including GTK and Clutter developed by the GNOME Project, Qt developed by the Qt Project and led by The Qt Company, and Enlightenment Foundation Libraries (EFL) developed primarily by the Enlightenment team.
                    A package management system, such as dpkg and RPM. Alternatively packages can be compiled from binary or source tarballs.
                    User interface programs such as command shells or windowing environments.
                
                User interface
                
                The user interface, also known as the shell, is either a command-line interface (CLI), a graphical user interface (GUI), or controls attached to the associated hardware, which is common for embedded systems. For desktop systems, the default user interface is usually graphical, although the CLI is commonly available through terminal emulator windows or on a separate virtual console.
                
                CLI shells are text-based user interfaces, which use text for both input and output. The dominant shell used in Linux is the Bourne-Again Shell (bash), originally developed for the GNU Project. Most low-level Linux components, including various parts of the userland, use the CLI exclusively. The CLI is particularly suited for automation of repetitive or delayed tasks and provides very simple inter-process communication.
                
                On desktop systems, the most popular user interfaces are the GUI shells, packaged together with extensive desktop environments, such as KDE Plasma, GNOME, MATE, Cinnamon, LXDE, Pantheon and Xfce, though a variety of additional user interfaces exist. Most popular user interfaces are based on the X Window System, often simply called "X". It provides network transparency and permits a graphical application running on one system to be displayed on another where a user may interact with the application; however, certain extensions of the X Window System are not capable of working over the network.[81] Several X display servers exist, with the reference implementation, X.Org Server, being the most popular.
                
                Server distributions might provide a command-line interface for developers and administrators, but provide a custom interface towards end-users, designed for the use-case of the system. This custom interface is accessed through a client that resides on another system, not necessarily Linux based.
                
                Several types of window managers exist for X11, including tiling, dynamic, stacking and compositing. Window managers provide means to control the placement and appearance of individual application windows, and interact with the X Window System. Simpler X window managers such as dwm, ratpoison, or i3wm provide a minimalist functionality, while more elaborate window managers such as FVWM, Enlightenment or Window Maker provide more features such as a built-in taskbar and themes, but are still lightweight when compared to desktop environments. Desktop environments include window managers as part of their standard installations, such as Mutter (GNOME), KWin (KDE) or Xfwm (xfce), although users may choose to use a different window manager if preferred.
                
                Wayland is a display server protocol intended as a replacement for the X11 protocol; as of 2022, it has received relatively wide adoption.[82] Unlike X11, Wayland does not need an external window manager and compositing manager. Therefore, a Wayland compositor takes the role of the display server, window manager and compositing manager. Weston is the reference implementation of Wayland, while GNOME's Mutter and KDE's KWin are being ported to Wayland as standalone display servers. Enlightenment has already been successfully ported since version 19.[83]
                Video input infrastructure
                Main article: Video4Linux
                
                Linux currently has two modern kernel-userspace APIs for handling video input devices: V4L2 API for video streams and radio, and DVB API for digital TV reception.[84]
                
                Due to the complexity and diversity of different devices, and due to the large number of formats and standards handled by those APIs, this infrastructure needs to evolve to better fit other devices. Also, a good userspace device library is the key of the success for having userspace applications to be able to work with all formats supported by those devices.[85][86]
                Development
                Simplified history of Unix-like operating systems. Linux shares similar architecture and concepts (as part of the POSIX standard) but does not share non-free source code with the original Unix or MINIX.
                Main articles: Linux distribution and Free software
                
                The primary difference between Linux and many other popular contemporary operating systems is that the Linux kernel and other components are free and open-source software. Linux is not the only such operating system, although it is by far the most widely used.[87] Some free and open-source software licenses are based on the principle of copyleft, a kind of reciprocity: any work derived from a copyleft piece of software must also be copyleft itself. The most common free software license, the GNU General Public License (GPL), is a form of copyleft, and is used for the Linux kernel and many of the components from the GNU Project.[88]
                
                Linux-based distributions are intended by developers for interoperability with other operating systems and established computing standards. Linux systems adhere to POSIX,[89] SUS,[90] LSB, ISO, and ANSI standards where possible, although to date only one Linux distribution has been POSIX.1 certified, Linux-FT.[91][92]
                
                Free software projects, although developed through collaboration, are often produced independently of each other. The fact that the software licenses explicitly permit redistribution, however, provides a basis for larger-scale projects that collect the software produced by stand-alone projects and make it available all at once in the form of a Linux distribution.
                
                Many Linux distributions manage a remote collection of system software and application software packages available for download and installation through a network connection. This allows users to adapt the operating system to their specific needs. Distributions are maintained by individuals, loose-knit teams, volunteer organizations, and commercial entities. A distribution is responsible for the default configuration of the installed Linux kernel, general system security, and more generally integration of the different software packages into a coherent whole. Distributions typically use a package manager such as apt, yum, zypper, pacman or portage to install, remove, and update all of a system's software from one central location.[93]
                Community
                See also: Free software community and Linux User Group
                
                A distribution is largely driven by its developer and user communities. Some vendors develop and fund their distributions on a volunteer basis, Debian being a well-known example. Others maintain a community version of their commercial distributions, as Red Hat does with Fedora, and SUSE does with openSUSE.[94][95]
                
                In many cities and regions, local associations known as Linux User Groups (LUGs) seek to promote their preferred distribution and by extension free software. They hold meetings and provide free demonstrations, training, technical support, and operating system installation to new users. Many Internet communities also provide support to Linux users and developers. Most distributions and free software / open-source projects have IRC chatrooms or newsgroups. Online forums are another means for support, with notable examples being LinuxQuestions.org and the various distribution specific support and community forums, such as ones for Ubuntu, Fedora, and Gentoo. Linux distributions host mailing lists; commonly there will be a specific topic such as usage or development for a given list.
                
                There are several technology websites with a Linux focus. Print magazines on Linux often bundle cover disks that carry software or even complete Linux distributions.[96][97]
                
                Although Linux distributions are generally available without charge, several large corporations sell, support, and contribute to the development of the components of the system and of free software. An analysis of the Linux kernel in 2017 showed that well over 85% of the code developed by programmers who are being paid for their work, leaving about 8.2% to unpaid developers and 4.1% unclassified.[98] Some of the major corporations that provide contributions include Intel, Samsung, Google, AMD, Oracle and Facebook.[98] A number of corporations, notably Red Hat, Canonical and SUSE, have built a significant business around Linux distributions.
                
                The free software licenses, on which the various software packages of a distribution built on the Linux kernel are based, explicitly accommodate and encourage commercialization; the relationship between a Linux distribution as a whole and individual vendors may be seen as symbiotic. One common business model of commercial suppliers is charging for support, especially for business users. A number of companies also offer a specialized business version of their distribution, which adds proprietary support packages and tools to administer higher numbers of installations or to simplify administrative tasks.
                
                Another business model is to give away the software to sell hardware. This used to be the norm in the computer industry, with operating systems such as CP/M, Apple DOS and versions of the classic Mac OS prior to 7.6 freely copyable (but not modifiable). As computer hardware standardized throughout the 1980s, it became more difficult for hardware manufacturers to profit from this tactic, as the OS would run on any manufacturer's computer that shared the same architecture.
                Programming on Linux
                
                Most programming languages support Linux either directly or through third-party community based ports.[99] The original development tools used for building both Linux applications and operating system programs are found within the GNU toolchain, which includes the GNU Compiler Collection (GCC) and the GNU Build System. Amongst others, GCC provides compilers for Ada, C, C++, Go and Fortran. Many programming languages have a cross-platform reference implementation that supports Linux, for example PHP, Perl, Ruby, Python, Java, Go, Rust and Haskell. First released in 2003, the LLVM project provides an alternative cross-platform open-source compiler for many languages. Proprietary compilers for Linux include the Intel C++ Compiler, Sun Studio, and IBM XL C/C++ Compiler. BASIC is available in procedural form from QB64, PureBasic, Yabasic, GLBasic, Basic4GL, XBasic, wxBasic, SdlBasic, and Basic-256, as well as object oriented through Gambas, FreeBASIC, B4X, Basic for Qt, Phoenix Object Basic, NS Basic, ProvideX, Chipmunk Basic, RapidQ and Xojo. Pascal is implemented through GNU Pascal, Free Pascal, and Virtual Pascal, as well as graphically via Lazarus, PascalABC.NET, or Delphi using FireMonkey (previously through Borland Kylix).
                
                A common feature of Unix-like systems, Linux includes traditional specific-purpose programming languages targeted at scripting, text processing and system configuration and management in general. Linux distributions support shell scripts, awk, sed and make. Many programs also have an embedded programming language to support configuring or programming themselves. For example, regular expressions are supported in programs like grep and locate, the traditional Unix message transfer agent Sendmail contains its own Turing complete scripting system, and the advanced text editor GNU Emacs is built around a general purpose Lisp interpreter.
                
                Most distributions also include support for PHP, Perl, Ruby, Python and other dynamic languages. While not as common, Linux also supports C# and other CLI languages (via Mono), Vala, and Scheme. Guile Scheme acts as an extension language targeting the GNU system utilities, seeking to make the conventionally small, static, compiled C programs of Unix design rapidly and dynamically extensible via an elegant, functional high-level scripting system; many GNU programs can be compiled with optional Guile bindings to this end. A number of Java virtual machines and development kits run on Linux, including the original Sun Microsystems JVM (HotSpot), and IBM's J2SE RE, as well as many open-source projects like Kaffe and Jikes RVM; Kotlin, Scala, Groovy and other JVM languages are also available.
                
                GNOME and KDE are popular desktop environments and provide a framework for developing applications. These projects are based on the GTK and Qt widget toolkits, respectively, which can also be used independently of the larger framework. Both support a wide variety of languages. There are a number of Integrated development environments available including Anjuta, Code::Blocks, CodeLite, Eclipse, Geany, ActiveState Komodo, KDevelop, Lazarus, MonoDevelop, NetBeans, and Qt Creator, while the long-established editors Vim, nano and Emacs remain popular.[100]
                Hardware support
                Linux is ubiquitously found on various types of hardware.
                See also: List of Linux-supported computer architectures
                
                The Linux kernel is a widely ported operating system kernel, available for devices ranging from mobile phones to supercomputers; it runs on a highly diverse range of computer architectures, including ARM-based Android smartphones and the IBM Z mainframes. Specialized distributions and kernel forks exist for less mainstream architectures; for example, the ELKS kernel fork can run on Intel 8086 or Intel 80286 16-bit microprocessors, while the µClinux kernel fork may run on systems without a memory management unit. The kernel also runs on architectures that were only ever intended to use a proprietary manufacturer-created operating system, such as Macintosh computers[101][102] (with PowerPC, Intel, and Apple silicon processors), PDAs, video game consoles, portable music players, and mobile phones.
                
                Linux has a reputation of supporting old hardware very well by maintaining standardized drivers for a long time.[103] There are several industry associations and hardware conferences devoted to maintaining and improving support for diverse hardware under Linux, such as FreedomHEC. Over time, support for different hardware has improved in Linux, resulting in any off-the-shelf purchase having a "good chance" of being compatible.[104]
                
                In 2014, a new initiative was launched to automatically collect a database of all tested hardware configurations.[105]
                Uses
                Main article: Linux range of use
                Market share and uptake
                Main article: Linux adoption
                See also: Usage share of operating systems
                
                Many quantitative studies of free/open-source software focus on topics including market share and reliability, with numerous studies specifically examining Linux.[106] The Linux market is growing, and the Linux operating system market size is expected to see a growth of 19.2% by 2027, reaching $15.64 billion, compared to $3.89 billion in 2019.[107] Analysts project a Compound Annual Growth Rate (CAGR) of 13.7% between 2024 and 2032, culminating in a market size of USD 34.90 billion by the latter year.[108] Analysts and proponents attribute the relative success of Linux to its security, reliability, low cost, and freedom from vendor lock-in.[109][110]
                
                Desktops and laptops
                    According to web server statistics (that is, based on the numbers recorded from visits to websites by client devices), as of May 2022, the estimated market share of Linux on desktop computers is around 2.5%. In comparison, Microsoft Windows has a market share of around 75.5%, while macOS covers around 14.9%.[26]
                
                Web servers
                
                    W3Cook publishes stats that use the top 1,000,000 Alexa domains,[111] which as of May 2015 estimate that 96.55% of web servers run Linux, 1.73% run Windows, and 1.72% run FreeBSD.[112]
                
                    W3Techs publishes stats that use the top 10,000,000 Alexa domains and the top 1,000,000 Tranco domains, updated monthly[113] and as of November 2020 estimate that Linux is used by 39% of the web servers, versus 21.9% being used by Microsoft Windows.[114] 40.1% used other types of Unix.[115]
                
                    IDC's Q1 2007 report indicated that Linux held 12.7% of the overall server market at that time;[116] this estimate was based on the number of Linux servers sold by various companies, and did not include server hardware purchased separately that had Linux installed on it later.
                
                Mobile devices
                    Android, which is based on the Linux kernel, has become the dominant operating system for smartphones. In April 2023, 68.61% of mobile devices accessing websites using StatCounter were from Android.[117] Android is also a popular operating system for tablets, being responsible for more than 60% of tablet sales as of 2013.[118] According to web server statistics, as of October 2021 Android has a market share of about 71%, with iOS holding 28%, and the remaining 1% attributed to various niche platforms.[119]
                
                Film production
                    For years, Linux has been the platform of choice in the film industry. The first major film produced on Linux servers was 1997's Titanic.[120][121] Since then major studios including DreamWorks Animation, Pixar, Weta Digital, and Industrial Light & Magic have migrated to Linux.[122][123][124] According to the Linux Movies Group, more than 95% of the servers and desktops at large animation and visual effects companies use Linux.[125]
                
                Use in government
                    Linux distributions have also gained popularity with various local and national governments. News of the Russian military creating its own Linux distribution has also surfaced, and has come to fruition as the G.H.ost Project.[126] The Indian state of Kerala has gone to the extent of mandating that all state high schools run Linux on their computers.[127][128] China uses Linux exclusively as the operating system for its Loongson processor family to achieve technology independence.[129] In Spain, some regions have developed their own Linux distributions, which are widely used in education and official institutions, like gnuLinEx in Extremadura and Guadalinex in Andalusia. France and Germany have also taken steps toward the adoption of Linux.[130] North Korea's Red Star OS, developed as of 2002, is based on a version of Fedora Linux.[131]
                
                Copyright, trademark, and naming
                See also: GNU/Linux naming controversy and SCO–Linux disputes
                
                The Linux kernel is licensed under the GNU General Public License (GPL), version 2. The GPL requires that anyone who distributes software based on source code under this license must make the originating source code (and any modifications) available to the recipient under the same terms.[132] Other key components of a typical Linux distribution are also mainly licensed under the GPL, but they may use other licenses; many libraries use the GNU Lesser General Public License (LGPL), a more permissive variant of the GPL, and the X.Org implementation of the X Window System uses the MIT License.
                
                Torvalds states that the Linux kernel will not move from version 2 of the GPL to version 3.[133][134] He specifically dislikes some provisions in the new license which prohibit the use of the software in digital rights management.[135] It would also be impractical to obtain permission from all the copyright holders, who number in the thousands.[136]
                
                A 2001 study of Red Hat Linux 7.1 found that this distribution contained 30 million source lines of code.[137] Using the Constructive Cost Model, the study estimated that this distribution required about eight thousand person-years of development time. According to the study, if all this software had been developed by conventional proprietary means, it would have cost about US$1.75 billion[138] to develop in 2022 in the United States.[137] Most of the source code (71%) was written in the C programming language, but many other languages were used, including C++, Lisp, assembly language, Perl, Python, Fortran, and various shell scripting languages. Slightly over half of all lines of code were licensed under the GPL. The Linux kernel itself was 2.4 million lines of code, or 8% of the total.[137]
                
                In a later study, the same analysis was performed for Debian version 4.0 (etch, which was released in 2007).[139] This distribution contained close to 283 million source lines of code, and the study estimated that it would have required about seventy three thousand man-years and cost US$9.8 billion[138] (in 2022 dollars) to develop by conventional means.
                
                The name "Linux" is also used for a laundry detergent made by Swiss company Rösch.[140]
                
                In the United States, the name Linux is a trademark registered to Linus Torvalds.[10] Initially, nobody registered it. However, on August 15, 1994, William R. Della Croce Jr. filed for the trademark Linux, and then demanded royalties from Linux distributors. In 1996, Torvalds and some affected organizations sued him to have the trademark assigned to Torvalds, and, in 1997, the case was settled.[141] The licensing of the trademark has since been handled by the Linux Mark Institute (LMI). Torvalds has stated that he trademarked the name only to prevent someone else from using it. LMI originally charged a nominal sublicensing fee for use of the Linux name as part of trademarks,[142] but later changed this in favor of offering a free, perpetual worldwide sublicense.[143]
                
                The Free Software Foundation (FSF) prefers GNU/Linux as the name when referring to the operating system as a whole, because it considers Linux distributions to be variants of the GNU operating system initiated in 1983 by Richard Stallman, president of the FSF.[16][17] They explicitly take no issue over the name Android for the Android OS, which is also an operating system based on the Linux kernel, as GNU is not a part of it.
                
                A minority of public figures and software projects other than Stallman and the FSF, notably Debian (which had been sponsored by the FSF up to 1996),[144] also use GNU/Linux when referring to the operating system as a whole.[145][146][147] Most media and common usage, however, refers to this family of operating systems simply as Linux, as do many large Linux distributions (for example, SUSE Linux and Red Hat Enterprise Linux). By contrast, Linux distributions containing only free software use "GNU/Linux" or simply "GNU", such as Trisquel GNU/Linux, Parabola GNU/Linux-libre, BLAG Linux and GNU, and gNewSense.
                
                As of May 2011, about 8% to 13% of the lines of code of the Linux distribution Ubuntu (version "Natty") is made of GNU components (the range depending on whether GNOME is considered part of GNU); meanwhile, 6% is taken by the Linux kernel, increased to 9% when including its direct dependencies.[148] 
            """);
            post03.setAccount(account01);
            postService.save(post03);

            Post post04 = new Post();
            post04.setTitle("Proton (software)");
            post04.setBody("""
                From Wikipedia, the free encyclopedia
                Not to be confused with Proton (technology company).
                ProtonDeveloper(s)	Valve
                CodeWeavers
                Initial release	August 21, 2018; 5 years ago
                Stable release	
                8.0-5 / October 6, 2023; 3 months ago
                Repository	github.com/ValveSoftware/Proton
                Operating system	Linux
                Available in	English
                Type	Compatibility layer
                License	
                
                    General: 3-clause BSD
                    Wine: LGPLv2.1+
                    DXVK (and D9VK in older versions): zlib
                    Steam API library: Proprietary
                
                Proton is a compatibility layer for Windows games to run on Linux-based operating systems.[1] Proton is developed by Valve in cooperation with developers from CodeWeavers.[2] It is a collection of software and libraries combined with a patched version of Wine to improve performance and compatibility with Windows games. Proton is designed for integration into the Steam client as "Steam Play".[3] It is officially distributed through the client, although third party forks can be manually installed.
                Overview
                
                Proton was initially released on 21 August 2018.[4] Upon release, Valve announced a list of 27 games that were tested and certified to perform like their native Windows counterparts without requiring end-user tweaking. These include Doom (2016), Quake, and Final Fantasy VI.[5][6][7][8]
                
                Proton incorporates several libraries that improve 3D performance. These include Direct3D-to-Vulkan translation layers, namely DXVK for Direct3D 9, 10 and 11, and VKD3D-Proton for Direct3D 12. A separate library known as D9VK handled Direct3D 9 support until it was merged into DXVK in December 2019.[9]
                Compatibility
                
                Being a fork of Wine, Proton maintains very similar compatibility with Windows applications as its upstream counterpart. In addition to the official list of compatible games, many other Windows games are compatible,[10] albeit unofficially, with Proton. The user can optionally force use of Proton for a specific title, even if a Linux version already exists.[11] This may be done when a game's official Linux support is lacking or possibly not stable.
                ProtonDB
                
                ProtonDB is an unofficial community website that collects and displays crowdsourced data describing the compatibility of a given title with Proton, on a rating scale from "Borked" to "Platinum".[12][13][14] The site is inspired by the WineHQ AppDB, which also collects and displays crowdsourced compatibility reports and uses a similar rating system.
                Release history
                
                Valve has released eight major versions of Proton. The versioning scheme refers to the upstream Wine version it's based on, with an appended patch number.[15]
                
                Proton generally lags behind its upstream Wine base by several releases. Unofficial forks, such as Proton GE,[16] have been created to re-base Proton on recent Wine versions, which may improve compatibility with games over the official release, and sometimes hurt it.[17]
                
                In December 2020, Valve released Proton Experimental, a perpetual beta branch of Proton that incorporates new features and bug fixes quicker than regular releases,[18] which are eventually included in a regular release.[19]
                
                The Steam Deck uses Proton to increase software title compatibility.[20]
                
            """);
            post04.setAccount(account01);
            postService.save(post04);

            Post post05 = new Post();
            post05.setTitle("LineageOS");
            post05.setBody("""
                LineageOS is an Android-based operating system for smartphones, tablet computers, and set-top boxes, with mostly free and open-source software. It is the successor to CyanogenMod, from which it was forked in December 2016, when Cyanogen Inc. announced it was discontinuing development and shut down the infrastructure behind the project.[5][6] Since Cyanogen Inc. retained the rights to the Cyanogen name, the project rebranded its fork as LineageOS.[7]

                LineageOS was officially launched on 24 December 2016, with the source code available on both GitHub and GitLab.[8][9] In March 2017, it reportedly had one million users with the OnePlus One being the most popular device.[10]
                History
                Main article: CyanogenMod
                
                CyanogenMod (often abbreviated "CM") was a popular[11] open-source operating system for smartphones and tablet computers, based on the Android mobile platform. CyanogenMod users can opt-in to report their use of the firmware.[12] In March 2015, Forbes indicated over 50 million people were running CyanogenMod on their phones.[11][13]
                
                In 2013, the founder, Stefanie Jane (formerly known as Steve Kondik and Stefanie Kondik), obtained venture funding under the name Cyanogen Inc. to allow commercialization of the project.[14][15] In her view, the company did not capitalize on the project's success and in 2016 she either left or was forced out[16][17] as part of a corporate restructure which involved a change of CEO, closure of offices and projects, and cessation of services.[18] The code itself, being both open source and popular, was forked under the new name LineageOS and efforts began to resume development as a community project.[citation needed]
                
                CyanogenMod offered a number of features and options not available in the official firmware distributed by most mobile device vendors. Features supported by CyanogenMod included native theme support,[19] FLAC audio codec support, a large Access Point Name list, Privacy Guard (per-application permission management application), support for tethering over common interfaces, CPU overclocking, root access, soft buttons and other "tablet tweaks," toggles in the notification pull-down (such as Wi-Fi, Bluetooth and satellite navigation), and other interface and performance enhancements.[citation needed] Many of the features from CyanogenMod were later integrated into the official Android code base.[citation needed] CyanogenMod's developers said that it did not contain spyware or bloatware.[20][21]
                Development
                    
                This section relies excessively on references to primary sources. Please improve this section by adding secondary or tertiary sources. (May 2022) (Learn how and when to remove this template message)
                
                Like CyanogenMod, the LineageOS project is developed by many device-specific maintainers and uses Gerrit for its code review process. It also retained the old versioning format, where the major version number corresponds to the place in the alphabet of the first letter of the codename (and of the commercial name for Android versions prior to 10) (for example, Android 7.1, known as Android Nougat, is LineageOS 14.1). Prior to the official launch of LineageOS, many developers from XDA had already developed unofficial versions of LineageOS from the source code. All the released builds are signed with LineageOS' private keys.[22]
                
                Builds were released on a weekly basis until 12 November 2018, when the release cycle for devices changed: the latest LineageOS branch is built daily, with devices receiving a "nightly" OTA update, while devices on the older branch were moved to a weekly release cycle.[23]
                
                Starting on 5 June 2020, the latest LineageOS branch moved back to a weekly release cycle, as the server couldn't build all available supported devices in just one day, with some devices receiving updates later on the next day.[24]
                Version history
                See also: Android version history and CyanogenMod § History and development
                
                    On 22 January 2017, the first official builds of versions 14.1 and 13.0 became available, following the official announcement in a blog post.[22]
                    On 11 February 2018, the builds of version 13.0 ceased,[25] while the source code remained available and security fixes were still accepted on Gerrit.
                    On 26 February 2018, the first official builds of version 15.1 became available on certain devices.[26] The 14.1 versions of Lineage OS were to remain in active development, but without feature advancements.
                    On 24 February 2019, the builds of version 14.1 ceased and builds of version 15.1 moved to a weekly cadence.[27]
                    On 1 March 2019, the first official builds of version 16.0 became available.[28] The version 15.1 branch remained in active development, but without feature advancements.
                    On 28 February 2020, the version 15.1 builds ceased in preparation for the version 17.1 release.[29]
                    On 1 April 2020, the first official builds of version 17.1 became available.[30] The version 16.0 builds were moved to a weekly cadence while the branch remained in active development, but without feature advancements.
                    On 16 February 2021, the version 16.0 builds ceased in preparation for the version 18.1 release.[31]
                    On 1 April 2021, the first official builds of version 18.1 became available.[32] The version 17.1 branch remained in active development.
                    On 16 February 2022, the builds of version 17.1 ceased in preparation for the version 19 release.[33]
                    On 26 April 2022, the first builds of version 19.1 became available.[34] The 18.1 branch remains in active development.
                    On 22 August 2022, the first builds of version 20 Gerrit patches became available, pending official announcement.[2] The version 18.1 and 19.1 branches remain in active development.
                    On 31 December 2022, the first builds of version 20 became available.[35] The 18.1 and 19.1 branches remain in active development.
                
                Version 	AOSP version 	First build release date 	Last build release date 	Support 	Ref.
                13.0 	6.0.1
                (Marshmallow) 	20 December 2016 as CM
                22 January 2017 as LOS 	11 February 2018 	Unsupported 	[22][25]
                14.1 	7.1.2
                (Nougat) 	9 November 2016 as CM
                22 January 2017 as LOS 	24 February 2019 	Unsupported 	[22][27]
                15.1 	8.1.0
                (Oreo) 	26 February 2018 	28 February 2020 	Unsupported 	[26][29]
                16.0 	9.0.0
                (Pie) 	1 March 2019 	16 February 2021 	Unsupported 	[28][31]
                17.1 	10
                (Quince Tart) 	1 April 2020 	16 February 2022 	Unsupported 	[30][33]
                18.1 	11
                (Red Velvet Cake) 	1 April 2021 	(Current) 	Supported 	[32]
                19.1 	12.1
                (Snow Cone) 	26 April 2022 	(Current) 	Supported 	[34]
                20 	13
                (Tiramisu) 	31 December 2022 	(Current) 	Supported 	[2]
                Legend:
                Old version
                Older version, still maintained
                Latest version
                Future release
                Features
                
                Like its predecessor, CyanogenMod, LineageOS is perceived as free from unnecessary software often pre-installed by a phone's manufacturer or carrier that is considered to be bloatware.[36][20]
                Community
                
                LineageOS allows the community to get involved with development in various ways. Gerrit is used for the code review process for both the operating system and the infrastructure.
                
                The wiki, containing information regarding installation, support, and development of LineageOS, is also open to contributions through Gerrit. Other Lineage platforms include Crowdin for managing translations, Gitlab Issues for bug tracking, and a stats page, which displays the number of active installations from users who opt in to report this statistic. There is also an IRC channel hosted on Libera.chat (#lineageos) and subreddit (r/lineageos).[37]
                
                The XDA Developers forums have been used by members of the Lineage community since the software's inception. Many devices are left unsupported by official releases so community members develop their own unofficial ROMs allowing older phones to use Lineage.[citation needed]
                
                During August 2017 the LineageOS team held a Summer Survey[38] in which they asked users for feedback to improve the development of the operating system. The results were published[39] in October and, according to the team, they used the gathered data to improve the upcoming LineageOS 15 release. A second Summer Survey was conducted in August 2018.[40]
                
                As a response to one of the main suggestions received during their first public survey, LineageOS launched a section on their blog titled "LineageOS Engineering Blog" where Lineage maintainers and developers can contribute articles discussing advanced technical information pertaining to Android development.[41]
                
                LineageOS is also known for posting a "regularly irregular review"[42] on its blog in which the active development of the work is discussed.
                LineageOS apps
                
                LineageOS includes free and open-source apps:
                
                Current
                
                    Aperture - A camera app maintained by various LineageOS developers, based on Google's CameraX library. It replaced Snap and Camera2 with the release of LineageOS 20.
                    AudioFX – Audio optimizer with presets to alter the listening experience.
                    Browser – A lightweight browser that relies on the system WebView, for low-end devices, also known as Jelly.
                    Calculator – Resembles a four-function calculator and offers some more advanced functions.
                    Calendar – Calendar functionality with Day, Week, Month, Year or Agenda views. A modified version of Etar is used, starting with version 17.1.
                    Clock – World clock, countdown timer, stopwatch and alarms.
                    Contacts – Phonebook for numbers and email addresses.
                    Files – A simple file manager to move, copy and rename files on internal storage or SD card.
                    FlipFlap – An app for smart flip covers, only included on select devices.
                    FM Radio – An app for listening to FM radio broadcasts, included on devices with an FM tuner.
                    Gallery – Organize photos and videos into a timeline or albums for easy viewing.
                    Messaging – An MMS/SMS messaging app.
                    Music – A simple music player, also known as Eleven.
                    Phone – Includes speed dial, phone number lookups and call blocking.
                    Recorder – A sound recorder. In versions prior to 18.1 it could also record the screen.
                    Trebuchet – A customizable launcher.
                
                Former
                
                    Camera – Dependent on device specification will take video or photos, including panoramic. It can also be used to read QR codes. This app is also known as Snap. This app is now replaced by Aperture.
                    Clock – A weather widget.
                    Email – Email client that handles POP3, IMAP and Exchange (removed in version 18.1).[43]
                    Gello – A browser based on Chromium and developed by CyanogenMod. This app is now replaced by Jelly.
                    Terminal – A simple and standard terminal app. Hidden unless enabled in the developer settings. (removed in version 18.1).[44]
                    Themes – Originally an app by itself, now integrated into the settings app.
                    WeatherUnderground Weather Provider – A weather provider.
                    Yahoo Weather Provider – A weather provider.
                
                Although they are not included in LineageOS as such due to legal issues,[45] users can flash the normal Google apps, including the Google Play Store and Play Apps, with a Zip package, usually referred to as gapps, while installing LineageOS. A side effect of using LineageOS and other custom roms is the impact on SafetyNet API.[46] App developers can choose to enable a toggle in the app developer console to hide their app on the Play Store if a device doesn't pass SafetyNet tests, or can choose to check the SafetyNet status of a device to disable certain functionality. Notable examples would be Netflix, which is hidden on the Play Store, and Google Pay, which checks SafetyNet each time the app is used. Devices running LineageOS may have a smaller selection of usable apps in the Play Store as a result of these checks. LineageOS can be made to work with apps such as Netflix and Google Pay by installing Magisk and certain modules designed to hide the bootloader status.[47]
                Customization features
                
                LineageOS offers several features that Android Open Source Project (AOSP) does not include. Some of these features are:
                
                    Button customization – Set custom location for buttons on the navigation bar, or enable on-screen buttons for devices with hardware buttons.[48]
                    Custom Quick-Setting tiles – Quick Setting Tiles such as "Caffeine" preventing the device from sleeping, enabling/disabling Heads Up notifications, "Ambient Display" and "ADB over network" are present to easily toggle frequently accessed settings.
                    LiveDisplay – Adjust color temperature for the time of day.
                    Lock screen customization – The lock screen allows all sorts of customizations, including media cover art, a music visualizer, and double-tap to sleep.
                    Styles – Set a global dark or light theme mode and customize accent colors. This functionality can also be managed automatically by the system based on wallpaper or time of day (in line with LiveDisplay).
                    System Profiles – Enable or disable common settings based on the selected profile (For example, a "Home" profile and a "Work" profile). The profile can be selected either manually or through the use of a "trigger", such as upon connecting to a specific WiFi access point, connecting to a Bluetooth device, or tapping an NFC tag.
                    Custom pattern sizes – In addition to Android's 3x3 pattern size, a 4x4, 5x5 or 6x6 size can be used.
                
                Security & privacy features
                
                    PIN scramble – For users securing their device with a PIN, the layout can be scrambled each time the device locks to make it difficult for people to figure out your lock by looking over your shoulder.
                    Privacy guard – Allow the user to fine-tune what permissions are granted to each application. For some permissions, it's possible to set a manual approval each time the permission is requested. It's also possible to find out how often apps use a specific permission. This feature was removed in the 17.1 branch in favor of an equivalent "permission controller" based on a hidden AOSP feature.
                    Protected Apps – Hide specific apps behind a secure lock. This works hand-in-hand with Trebuchet; the app's icon is removed from the launcher, and "secure folders" can be created to easily access these applications. A pattern is used to lock these apps.
                    Some "sensitive numbers", such as abuse support numbers, are not included in the call log for privacy.[49] The phone application also includes a list of helpline numbers for the users to be able to easily reach them.[32]
                    Trust - helps to keep the device secure and protects privacy.[50]
                
                Developers & power user features
                
                    LineageSDK – a set of APIs for app developers to integrate their apps with LineageOS specific features such as System Profiles, Styles and Weather.[51]
                    Lineage Recovery - an AOSP-based recovery.
                    (Optional) Root – Permit apps to function with root access to perform advanced tasks. This requires flashing from Recovery either LineageOS's root add-on (supported until version 16.0[52]) or a third-party implementation such as Magisk or SuperSU.
                    Telephone call recorder, not available in all countries, due to legal restrictions.
                
                Trust interface
                
                As LineageOS evolved through development, the Trust interface was introduced for all the LineageOS 15.1 builds released since 12 June 2018.[53] The interface can be found on supported devices under Security and Privacy tab under the Settings option, and enables the user to "get an overview of the status of core security features and explanations on how to act to make sure the device is secure and the data is private".
                
                Additionally, while carrying out any action on the device, the trust icon is displayed, notifying the user that the action is safe.
                Supported devices
                POCO X3 Pro smartphone running LineageOS
                
                The number of devices supported by LineageOS has increased over time, with 51 for 18.1 and 183 for 20 as of December 3, 2023.[54][55] Official builds on currently supported development branches are labeled as "nightly". For the first two months of the project, parallel experimental builds were also produced, allowing in-place upgrades from previous CyanogenMod installations and easing migration to LineageOS.[55][56][57]
                
                In 2019, LineageOS development builds were available for 109 phone models[54] with over 3.0 million active installs.[58] As of 26 April 2022, 41 devices are receiving official 19 builds and 136 devices are receiving official 18.1 builds.
                
                The compatibility layer Waydroid (formerly called Anbox-Halium) is using LineageOS in an LXC container in order to use Android apps on a desktop or mobile Linux distribution.[59]
                Criticism and reception
                2018 April Fools' prank
                
                LineageOS was criticized for a deceptive April Fool's prank included with some April 2018 builds.[60]
                
                During the first week of April 2018 LineageOS released new builds with the "LOSGenuine" prank that informed unaware users of the software possibly being counterfeit via a persistent notification (which could not be disabled unless the user ran the following command in a root shell):
                
                setprop persist.lineage.nofool true
                
                When the notification was tapped, the software claimed that the device was "uncertified" and needed to mine "LOSCoins", which were a virtual currency and could not actually be spent. Affected builds also had a preinstalled "Wallet" app that showed the current balance of LOSCoins.[60]
                
                Many users mistook the prank for actual malware, and others reportedly found it to be in "poor taste". It was especially criticized for being too "late" for an April Fool's joke, since many users didn't receive the update until days later, making the jest less obvious. On 10 April 2018, LineageOS team director ciwrl issued an official apology for the deceptive prank.[61][62]
                Forks
                
                LineageOS has a number of notable forks:
                
                    Replicant intends to be a completely free software variant of LineageOS, with all kernel blobs and non-free drivers removed.
                    As a response to the refusal for several reasons of support for signature spoofing in official builds,[63] a LineageOS fork with microG[64] services included, known as "LineageOS for microG", was created. The project ships custom builds of LineageOS with the required patch and native F-Droid support, bundled with the MicroG project's free re-implementation of proprietary Gapps.[65][66] In other respects it follows upstream, shipping OTA updates every fourteen days.[67]
                    CalyxOS is a privacy and security-focused operating system for smartphones, based on Android Open Source Project (AOSP). CalyxOS makes available during installation optional privacy-preserving apps such as Orbot, Tor Browser, Signal, Calyx VPN, Riseup VPN and MicroG support.[68][69]
                    DivestOS is a soft fork of LineageOS that aims to increase security and privacy, and support older devices. As much as possible it removes proprietary Android components and includes only free-software.[70]
                    /e/ is a fork of LineageOS created by Gaël Duval that is intended to be "free from Google". It replaces Google Play Services with microG, a free and open-source implementation of Google APIs.[71]
                    IodéOS is a fork of LineageOS developed by French company iodé, it does not include Google Play Services, instead using microG as a free and open-source replacement.[72]
            """);
            post05.setAccount(account01);
            postService.save(post05);

            Post post06 = new Post();
            post06.setTitle("Android (operating system)");
            post06.setBody("""
                Android is a mobile operating system (32-bit and 64-bit) based on a modified version of the Linux kernel and other open-source software, designed primarily for touchscreen mobile devices such as smartphones and tablets. Android is developed by a consortium of developers known as the Open Handset Alliance, though its most widely used version is primarily developed by Google. It was unveiled in November 2007, with the first commercial Android device, the HTC Dream, being launched in September 2008.

                At its core, the operating system is known as the Android Open Source Project (AOSP)[4] and is free and open-source software (FOSS) primarily licensed under the Apache License. However, most devices run on the proprietary Android version developed by Google, which ships with additional proprietary closed-source software pre-installed,[5] most notably Google Mobile Services (GMS)[6] which includes core apps such as Google Chrome, the digital distribution platform Google Play, and the associated Google Play Services development platform. Firebase Cloud Messaging is used for push notifications. While AOSP is free, the "Android" name and logo are trademarks of Google, which imposes standards to restrict the use of Android branding by "uncertified" devices outside their ecosystem.[7][8]
                
                Over 70 percent of smartphones based on the Android Open Source Project run Google's ecosystem (which is known simply as Android), some with vendor-customized user interfaces and software suites, such as TouchWiz and later One UI by Samsung and HTC Sense.[9] Competing ecosystems and forks of AOSP include Fire OS (developed by Amazon), ColorOS by Oppo, OriginOS by Vivo, MagicUI by Honor, or custom ROMs such as LineageOS.
                
                The source code has been used to develop variants of Android on a range of other electronics, such as game consoles, digital cameras, portable media players, and PCs, each with a specialized user interface. Some well-known derivatives include Android TV for televisions and Wear OS for wearables, both developed by Google. Software packages on Android, which use the APK format, are generally distributed through proprietary application stores like Google Play Store, Amazon Appstore (including for Windows 11), Samsung Galaxy Store, Huawei AppGallery, Cafe Bazaar, GetJar, and Aptoide, or open source platforms like F-Droid.
                
                Android has been the best-selling OS worldwide on smartphones since 2011 and on tablets since 2013. As of May 2021, it had over three billion monthly active users, the largest installed base of any operating system in the world,[10] and as of January 2021, the Google Play Store featured over 3 million apps.[11] Android 14, released on October 4, 2023, is the latest version, and the recently released Android 12.1/12L includes improvements specific to foldable phones, tablets, desktop-sized screens[12] and Chromebooks.
                History
                See also: Android version history
                
                Android Inc. was founded in Palo Alto, California, in October 2003 by Andy Rubin, Rich Miner, Nick Sears, and Chris White.[13][14] Rubin described the Android project as having "tremendous potential in developing smarter mobile devices that are more aware of its owner's location and preferences".[14] The early intentions of the company were to develop an advanced operating system for digital cameras, and this was the basis of its pitch to investors in April 2004.[15] The company then decided that the market for cameras was not large enough for its goals, and five months later it had diverted its efforts and was pitching Android as a handset operating system that would rival Symbian and Microsoft Windows Mobile.[15][16]
                
                Rubin had difficulty attracting investors early on, and Android was facing eviction from its office space. Steve Perlman, a close friend of Rubin, brought him $10,000 in cash in an envelope, and shortly thereafter wired an undisclosed amount as seed funding. Perlman refused a stake in the company, and has stated "I did it because I believed in the thing, and I wanted to help Andy."[17][18]
                
                In 2005, Rubin tried to negotiate deals with Samsung[19] and HTC.[20] Shortly afterwards, Google acquired the company in July of that year for at least $50 million;[14][21] this was Google's "best deal ever" according to Google's then-vice president of corporate development, David Lawee, in 2010.[19] Android's key employees, including Rubin, Miner, Sears, and White, joined Google as part of the acquisition.[14] Not much was known about the secretive Android Inc. at the time, with the company having provided few details other than that it was making software for mobile phones.[14] At Google, the team led by Rubin developed a mobile device platform powered by the Linux kernel. Google marketed the platform to handset makers and carriers on the promise of providing a flexible, upgradeable system.[22] Google had "lined up a series of hardware components and software partners and signaled to carriers that it was open to various degrees of cooperation".[attribution needed][23]
                
                Speculation about Google's intention to enter the mobile communications market continued to build through December 2006.[24] An early prototype had a close resemblance to a BlackBerry phone, with no touchscreen and a physical QWERTY keyboard, but the arrival of 2007's Apple iPhone meant that Android "had to go back to the drawing board".[25][26] Google later changed its Android specification documents to state that "Touchscreens will be supported", although "the Product was designed with the presence of discrete physical buttons as an assumption, therefore a touchscreen cannot completely replace physical buttons".[27] By 2008, both Nokia and BlackBerry announced touch-based smartphones to rival the iPhone 3G, and Android's focus eventually switched to just touchscreens. The first commercially available smartphone running Android was the HTC Dream, also known as T-Mobile G1, announced on September 23, 2008.[28][29]
                HTC Dream or T-Mobile G1, the first commercially released device running Android (2008)
                
                On November 5, 2007, the Open Handset Alliance, a consortium of technology companies including Google, device manufacturers such as HTC, Motorola and Samsung, wireless carriers such as Sprint and T-Mobile, and chipset makers such as Qualcomm and Texas Instruments, unveiled itself, with a goal to develop "the first truly open and comprehensive platform for mobile devices".[30][31][32] Within a year, the Open Handset Alliance faced two other open source competitors, the Symbian Foundation and the LiMo Foundation, the latter also developing a Linux-based mobile operating system like Google. In September 2007, InformationWeek covered an Evalueserve study reporting that Google had filed several patent applications in the area of mobile telephony.[33][34]
                
                On September 23, 2008, Android was introduced by Andy Rubin, Larry Page, Sergey Brin, Cole Brodman, Christopher Schlaeffer and Peter Chou at a press conference in a New York subway station.[35]
                
                Since 2008, Android has seen numerous updates which have incrementally improved the operating system, adding new features and fixing bugs in previous releases. Each major release is named in alphabetical order after a dessert or sugary treat, with the first few Android versions being called "Cupcake", "Donut", "Eclair", and "Froyo", in that order. During its announcement of Android KitKat in 2013, Google explained that "Since these devices make our lives so sweet, each Android version is named after a dessert", although a Google spokesperson told CNN in an interview that "It's kind of like an internal team thing, and we prefer to be a little bit—how should I say—a bit inscrutable in the matter, I'll say".[36]
                
                In 2010, Google launched its Nexus series of devices, a lineup in which Google partnered with different device manufacturers to produce new devices and introduce new Android versions. The series was described as having "played a pivotal role in Android's history by introducing new software iterations and hardware standards across the board", and became known for its "bloat-free" software with "timely ... updates".[37] At its developer conference in May 2013, Google announced a special version of the Samsung Galaxy S4, where, instead of using Samsung's own Android customization, the phone ran "stock Android" and was promised to receive new system updates fast.[38] The device would become the start of the Google Play edition program, and was followed by other devices, including the HTC One Google Play edition,[39] and Moto G Google Play edition.[40] In 2015, Ars Technica wrote that "Earlier this week, the last of the Google Play edition Android phones in Google's online storefront were listed as "no longer available for sale" and that "Now they're all gone, and it looks a whole lot like the program has wrapped up".[41][42]
                Eric Schmidt, Andy Rubin and Hugo Barra at a 2012 press conference announcing Google's Nexus 7 tablet
                
                From 2008 to 2013, Hugo Barra served as product spokesperson, representing Android at press conferences and Google I/O, Google's annual developer-focused conference. He left Google in August 2013 to join Chinese phone maker Xiaomi.[43][44] Less than six months earlier, Google's then-CEO Larry Page announced in a blog post that Andy Rubin had moved from the Android division to take on new projects at Google, and that Sundar Pichai would become the new Android lead.[45][46] Pichai himself would eventually switch positions, becoming the new CEO of Google in August 2015 following the company's restructure into the Alphabet conglomerate,[47][48] making Hiroshi Lockheimer the new head of Android.[49][50]
                
                On Android 4.4 Kit Kat, shared writing access to MicroSD memory cards has been locked for user-installed applications, to which only the dedicated directories with respective package names, located inside Android/data/, remained writeable. Writing access has been reinstated with Android 5 Lollipop through the backwards-incompatible Google Storage Access Framework interface.[51]
                
                In June 2014, Google announced Android One, a set of "hardware reference models" that would "allow [device makers] to easily create high-quality phones at low costs", designed for consumers in developing countries.[52][53][54] In September, Google announced the first set of Android One phones for release in India.[55][56] However, Recode reported in June 2015 that the project was "a disappointment", citing "reluctant consumers and manufacturing partners" and "misfires from the search company that has never quite cracked hardware".[57] Plans to relaunch Android One surfaced in August 2015,[58] with Africa announced as the next location for the program a week later.[59][60] A report from The Information in January 2017 stated that Google is expanding its low-cost Android One program into the United States, although The Verge notes that the company will presumably not produce the actual devices itself.[61][62] Google introduced the Pixel and Pixel XL smartphones in October 2016, marketed as being the first phones made by Google,[63][64] and exclusively featured certain software features, such as the Google Assistant, before wider rollout.[65][66] The Pixel phones replaced the Nexus series,[67] with a new generation of Pixel phones launched in October 2017.[68]
                
                In May 2019, the operating system became entangled in the trade war between China and the United States involving Huawei, which, like many other tech firms, had become dependent on access to the Android platform.[69][70] In the summer of 2019, Huawei announced it would create an alternative operating system to Android[71] known as Harmony OS,[72] and has filed for intellectual property rights across major global markets.[73][74] Under such sanctions Huawei has long-term plans to replace Android in 2022 with the new operating system, as Harmony OS was originally designed for internet of things devices, rather than for smartphones and tablets.[75]
                
                On August 22, 2019, it was announced that Android "Q" would officially be branded as Android 10, ending the historic practice of naming major versions after desserts. Google stated that these names were not "inclusive" to international users (due either to the aforementioned foods not being internationally known, or being difficult to pronounce in some languages).[76][77] On the same day, Android Police reported that Google had commissioned a statue of a giant number "10" to be installed in the lobby of the developers' new office.[78] Android 10 was released on September 3, 2019, to Google Pixel phones first.
                
                In late 2021, some users reported that they were unable to dial emergency services.[79][80] The problem was caused by a combination of bugs in Android and in the Microsoft Teams app; both companies released updates addressing the issue.[81]
                Features
                Main article: List of features in Android
                Interface
                
                Android's default user interface is mainly based on direct manipulation, using touch inputs that loosely correspond to real-world actions, like swiping, tapping, pinching, and reverse pinching to manipulate on-screen objects, along with a virtual keyboard.[82] Game controllers and full-size physical keyboards are supported via Bluetooth or USB.[83][84] The response to user input is designed to be immediate and provides a fluid touch interface, often using the vibration capabilities of the device to provide haptic feedback to the user. Internal hardware, such as accelerometers, gyroscopes and proximity sensors are used by some applications to respond to additional user actions, for example adjusting the screen from portrait to landscape depending on how the device is oriented,[85] or allowing the user to steer a vehicle in a racing game by rotating the device, simulating control of a steering wheel.[86]
                Home screen
                
                Android devices boot to the home screen, the primary navigation and information "hub" on Android devices, analogous to the desktop found on personal computers. Android home screens are typically made up of app icons and widgets; app icons launch the associated app, whereas widgets display live, auto-updating content, such as a weather forecast, the user's email inbox, or a news ticker directly on the home screen.[87] A home screen may be made up of several pages, between which the user can swipe back and forth.[88] Third-party apps available on Google Play and other app stores can extensively re-theme the home screen,[89] and even mimic the look of other operating systems, such as Windows Phone.[90] Most manufacturers customize the look and features of their Android devices to differentiate themselves from their competitors.[91]
                Status bar
                
                Along the top of the screen is a status bar, showing information about the device and its connectivity. This status bar can be pulled (swiped) down from to reveal a notification screen where apps display important information or updates, as well as quick access to system controls and toggles such as display brightness, connectivity settings (WiFi, Bluetooth, cellular data), audio mode, and flashlight.[88] Vendors may implement extended settings such as the ability to adjust the flashlight brightness.[92]
                Notifications
                
                Notifications are "short, timely, and relevant information about your app when it's not in use", and when tapped, users are directed to a screen inside the app relating to the notification.[93] Beginning with Android 4.1 "Jelly Bean", "expandable notifications" allow the user to tap an icon on the notification in order for it to expand and display more information and possible app actions right from the notification.[94]
                App lists
                
                An "All Apps" screen lists all installed applications, with the ability for users to drag an app from the list onto the home screen. The app list may be accessed using a gesture or a button, depending on the Android version. A "Recents" screen, also known as "Overview", lets users switch between recently used apps.[88]
                
                The recent list may appear side-by-side or overlapping, depending on the Android version and manufacturer.[95]
                Navigation buttons
                Front buttons (home, menu/options, go back, search) and optical track pad of an HTC Desire, a 2010 smartphone with Android OS
                
                Many early Android OS smartphones were equipped with a dedicated search button for quick access to a web search engine and individual apps' internal search feature. More recent devices typically allow the former through a long press or swipe away from the home button.[96]
                
                The dedicated option key, also known as menu key, and its on-screen simulation, is no longer supported since Android version 10. Google recommends mobile application developers to locate menus within the user interface.[96] On more recent phones, its place is occupied by a task key used to access the list of recently used apps when actuated. Depending on device, its long press may simulate a menu button press or engage split screen view, the latter of which is the default behaviour since stock Android version 7.[97][98][99]
                Split-screen view
                
                Native support for split screen view has been added in stock Android version 7.0 Nougat.[99]
                
                The earliest vendor-customized Android-based smartphones known to have featured a split-screen view mode are the 2012 Samsung Galaxy S3 and Note 2, the former of which received this feature with the premium suite upgrade delivered in TouchWiz with Android 4.1 Jelly Bean.[100]
                Charging while powered off
                
                When connecting or disconnecting charging power and when shortly actuating the power button or home button, all while the device is powered off, a visual battery meter whose appearance varies among vendors appears on the screen, allowing the user to quickly assess the charge status of a powered-off without having to boot it up first. Some display the battery percentage.[101]
                Applications
                See also: Android software development and Google Play
                
                Many, to almost all, Android devices come with preinstalled Google apps including Gmail, Google Maps, Google Chrome, YouTube, Google Play Music, Google Play Movies & TV, and many more.
                
                Applications ("apps"), which extend the functionality of devices (and must be 64-bit[102]), are written using the Android software development kit (SDK)[103] and, often, Kotlin programming language, which replaced Java as Google's preferred language for Android app development in May 2019,[104] and was originally announced in May 2017.[105][106] Java is still supported (originally the only option for user-space programs, and is often mixed with Kotlin), as is C++.[107] Java or other JVM languages, such as Kotlin, may be combined with C/C++,[108] together with a choice of non-default runtimes that allow better C++ support.[109] The Go programming language is also supported, although with a limited set of application programming interfaces (API).[110]
                
                The SDK includes a comprehensive set of development tools,[111] including a debugger, software libraries, a handset emulator based on QEMU, documentation, sample code, and tutorials. Initially, Google's supported integrated development environment (IDE) was Eclipse using the Android Development Tools (ADT) plugin; in December 2014, Google released Android Studio, based on IntelliJ IDEA, as its primary IDE for Android application development. Other development tools are available, including a native development kit (NDK) for applications or extensions in C or C++, Google App Inventor, a visual environment for novice programmers, and various cross platform mobile web applications frameworks. In January 2014, Google unveiled a framework based on Apache Cordova for porting Chrome HTML 5 web applications to Android, wrapped in a native application shell.[112] Additionally, Firebase was acquired by Google in 2014 that provides helpful tools for app and web developers.[113]
                
                Android has a growing selection of third-party applications, which can be acquired by users by downloading and installing the application's APK (Android application package) file, or by downloading them using an application store program that allows users to install, update, and remove applications from their devices. Google Play Store is the primary application store installed on Android devices that comply with Google's compatibility requirements and license the Google Mobile Services software.[114][115] Google Play Store allows users to browse, download and update applications published by Google and third-party developers; as of January 2021, there are more than three million applications available for Android in Play Store.[11][116] As of July 2013, 50 billion application installations had been performed.[117][118] Some carriers offer direct carrier billing for Google Play application purchases, where the cost of the application is added to the user's monthly bill.[119] As of May 2017, there are over one billion active users a month for Gmail, Android, Chrome, Google Play and Maps.
                
                Due to the open nature of Android, a number of third-party application marketplaces also exist for Android, either to provide a substitute for devices that are not allowed to ship with Google Play Store, provide applications that cannot be offered on Google Play Store due to policy violations, or for other reasons. Examples of these third-party stores have included the Amazon Appstore, GetJar, and SlideMe. F-Droid, another alternative marketplace, seeks to only provide applications that are distributed under free and open source licenses.[114][120][121][122]
                
                In October 2020, Google removed several Android applications from Play Store, as they were identified breaching its data collection rules. The firm was informed by International Digital Accountability Council (IDAC) that apps for children like Number Coloring, Princess Salon and Cats & Cosplay, with collective downloads of 20 million, were violating Google's policies.[123]
                
                At the Windows 11 announcement event in June 2021, Microsoft showcased the new Windows Subsystem for Android (WSA) that will enable support for the Android Open Source Project (AOSP) and will allow users to run Android apps on their Windows desktop.[124]
                Storage
                
                The storage of Android devices can be expanded using secondary devices such as SD cards. Android recognizes two types of secondary storage: portable storage (which is used by default), and adoptable storage. Portable storage is treated as an external storage device. Adoptable storage, introduced on Android 6.0, allows the internal storage of the device to be spanned with the SD card, treating it as an extension of the internal storage. This has the disadvantage of preventing the memory card from being used with another device unless it is reformatted.[125]
                
                Android 4.4 introduced the Storage Access Framework (SAF), a set of APIs for accessing files on the device's filesystem.[126] As of Android 11, Android has required apps to conform to a data privacy policy known as scoped storage, under which apps may only automatically have access to certain directories (such as those for pictures, music, and video), and app-specific directories they have created themselves. Apps are required to use the SAF to access any other part of the filesystem.[127][128][129]
                Memory management
                
                Since Android devices are usually battery-powered, Android is designed to manage processes to keep power consumption at a minimum. When an application is not in use the system suspends its operation so that, while available for immediate use rather than closed, it does not use battery power or CPU resources.[130][131] Android manages the applications stored in memory automatically: when memory is low, the system will begin invisibly and automatically closing inactive processes, starting with those that have been inactive for the longest amount of time.[132][133] Lifehacker reported in 2011 that third-party task-killer applications were doing more harm than good.[134]
                Developer options
                
                Some settings for use by developers for debugging and power users are located in a "Developer options" sub menu, such as the ability to highlight updating parts of the display, show an overlay with the current status of the touch screen, show touching spots for possible use in screencasting, notify the user of unresponsive background processes with the option to end them ("Show all ANRs", i.e. "App's Not Responding"), prevent a Bluetooth audio client from controlling the system volume ("Disable absolute volume"), and adjust the duration of transition animations or deactivate them completely to speed up navigation.[135][136][137]
                
                Developer options are initially hidden since Android 4.2 "Jelly Bean", but can be enabled by actuating the operating system's build number in the device information seven times. Hiding developers options again requires deleting user data for the "Settings" app, possibly resetting some other preferences.[138][139][140]
                Hardware
                See also: Android hardware requirements
                
                The main hardware platform for Android is ARM (the ARMv7 and ARMv8-A architectures), with x86 and x86-64 architectures also officially supported in later versions of Android.[141][142][143] The unofficial Android-x86 project provided support for x86 architectures ahead of the official support.[144][145] Since 2012, Android devices with Intel processors began to appear, including phones[146] and tablets. While gaining support for 64-bit platforms, Android was first made to run on 64-bit x86 and then on ARM64. An unofficial experimental port of the operating system to the RISC-V architecture was released in 2021.[147]
                
                Requirements for the minimum amount of RAM for devices running Android 7.1 range from in practice 2 GB for best hardware, down to 1 GB for the most common screen. Android supports all versions of OpenGL ES and Vulkan (and version 1.1 available for some devices[148]).
                
                Android devices incorporate many optional hardware components, including still or video cameras, GPS, orientation sensors, dedicated gaming controls, accelerometers, gyroscopes, barometers, magnetometers, proximity sensors, pressure sensors, thermometers, and touchscreens. Some hardware components are not required, but became standard in certain classes of devices, such as smartphones, and additional requirements apply if they are present. Some other hardware was initially required, but those requirements have been relaxed or eliminated altogether. For example, as Android was developed initially as a phone OS, hardware such as microphones were required, while over time the phone function became optional.[118] Android used to require an autofocus camera, which was relaxed to a fixed-focus camera[118] if present at all, since the camera was dropped as a requirement entirely when Android started to be used on set-top boxes.
                
                In addition to running on smartphones and tablets, several vendors run Android natively on regular PC hardware with a keyboard and mouse.[149][150][151][152] In addition to their availability on commercially available hardware, similar PC hardware-friendly versions of Android are freely available from the Android-x86 project, including customized Android 4.4.[153] Using the Android emulator that is part of the Android SDK, or third-party emulators, Android can also run non-natively on x86 architectures.[154][155] Chinese companies are building a PC and mobile operating system, based on Android, to "compete directly with Microsoft Windows and Google Android".[156] The Chinese Academy of Engineering noted that "more than a dozen" companies were customizing Android following a Chinese ban on the use of Windows 8 on government PCs.[157][158][159]
                Development
                The stack of Android Open Source Project
                
                Android is developed by Google until the latest changes and updates are ready to be released, at which point the source code is made available to the Android Open Source Project (AOSP),[160] an open source initiative led by Google.[161] The first source code release happened as part of the initial release in 2007. All releases are under the Apache License.[162]
                
                The AOSP code can be found with minimal modifications on select devices, mainly the former Nexus and current Android One series of devices.[163] However, most original equipment manufacturers (OEMs) customize the source code to run on their hardware.[164][165]
                
                Android's source code does not contain the device drivers, often proprietary, that are needed for certain hardware components,[166] and does not contain the source code of Google Play Services, which many apps depend on. As a result, most Android devices, including Google's own, ship with a combination of free and open source and proprietary software, with the software required for accessing Google services falling into the latter category.[citation needed] In response to this, there are some projects that build complete operating systems based on AOSP as free software, the first being CyanogenMod (see section Open-source community below).
                Update schedule
                See also: Android version history
                
                Google provides annual[167] Android releases, both for factory installation in new devices, and for over-the-air updates to existing devices.[168] The latest major release is Android 14.
                
                The extensive variation of hardware[169] in Android devices has caused significant delays for software upgrades and security patches. Each upgrade has had to be specifically tailored, a time- and resource-consuming process.[170] Except for devices within the Google Nexus and Pixel brands, updates have often arrived months after the release of the new version, or not at all.[171] Manufacturers often prioritize their newest devices and leave old ones behind.[172] Additional delays can be introduced by wireless carriers who, after receiving updates from manufacturers, further customize Android to their needs and conduct extensive testing on their networks before sending out the upgrade.[172][173] There are also situations in which upgrades are impossible due to a manufacturer not updating necessary drivers.[174]
                
                The lack of after-sale support from manufacturers and carriers has been widely criticized by consumer groups and the technology media.[175][176][177] Some commentators have noted that the industry has a financial incentive not to upgrade their devices, as the lack of updates for existing devices fuels the purchase of newer ones,[178] an attitude described as "insulting".[177] The Guardian complained that the method of distribution for updates is complicated only because manufacturers and carriers have designed it that way.[177] In 2011, Google partnered with a number of industry players to announce an "Android Update Alliance", pledging to deliver timely updates for every device for 18 months after its release; however, there has not been another official word about that alliance since its announcement.[172][179]
                
                In 2012, Google began de-coupling certain aspects of the operating system (particularly its central applications) so they could be updated through the Google Play store independently of the OS. One of those components, Google Play Services, is a closed-source system-level process providing APIs for Google services, installed automatically on nearly all devices running Android 2.2 "Froyo" and higher. With these changes, Google can add new system functions and update apps without having to distribute an upgrade to the operating system itself.[180] As a result, Android 4.2 and 4.3 "Jelly Bean" contained relatively fewer user-facing changes, focusing more on minor changes and platform improvements.[181]
                
                HTC's then-executive Jason Mackenzie called monthly security updates "unrealistic" in 2015, and Google was trying to persuade carriers to exclude security patches from the full testing procedures. In May 2016, Bloomberg Businessweek reported that Google was making efforts to keep Android more up-to-date, including accelerated rates of security updates, rolling out technological workarounds, reducing requirements for phone testing, and ranking phone makers in an attempt to "shame" them into better behavior. As stated by Bloomberg: "As smartphones get more capable, complex and hackable, having the latest software work closely with the hardware is increasingly important". Hiroshi Lockheimer, the Android lead, admitted that "It's not an ideal situation", further commenting that the lack of updates is "the weakest link on security on Android". Wireless carriers were described in the report as the "most challenging discussions", due to their slow approval time while testing on their networks, despite some carriers, including Verizon Wireless and Sprint Corporation, already shortening their approval times. In a further effort for persuasion, Google shared a list of top phone makers measured by updated devices with its Android partners, and is considering making the list public.[when?] Mike Chan, co-founder of phone maker Nextbit and former Android developer, said that "The best way to solve this problem is a massive re-architecture of the operating system", "or Google could invest in training manufacturers and carriers 'to be good Android citizens'".[182][183][184]
                
                In May 2017, with the announcement of Android 8.0, Google introduced Project Treble, a major re-architect of the Android OS framework designed to make it easier, faster, and less costly for manufacturers to update devices to newer versions of Android. Project Treble separates the vendor implementation (device-specific, lower-level software written by silicon manufacturers) from the Android OS framework via a new "vendor interface". In Android 7.0 and earlier, no formal vendor interface exists, so device makers must update large portions of the Android code to move a device to a newer version of the operating system. With Treble, the new stable vendor interface provides access to the hardware-specific parts of Android, enabling device makers to deliver new Android releases simply by updating the Android OS framework, "without any additional work required from the silicon manufacturers."[185]
                
                In September 2017, Google's Project Treble team revealed that, as part of their efforts to improve the security lifecycle of Android devices, Google had managed to get the Linux Foundation to agree to extend the support lifecycle of the Linux Long-Term Support (LTS) kernel branch from the 2 years that it has historically lasted to 6 years for future versions of the LTS kernel, starting with Linux kernel 4.4.[186]
                
                In May 2019, with the announcement of Android 10, Google introduced Project Mainline to simplify and expedite delivery of updates to the Android ecosystem. Project Mainline enables updates to core OS components through the Google Play Store. As a result, important security and performance improvements that previously needed to be part of full OS updates can be downloaded and installed as easily as an app update.[187]
                
                Google reported rolling out new amendments in Android 12 aimed at making the use of third-party application stores easier. This announcement rectified the concerns reported regarding the development of Android apps, including a fight over an alternative in-app payment system and difficulties faced by businesses moving online because of COVID-19.[188]
                Linux kernel
                
                Android's kernel is based on the Linux kernel's long-term support (LTS) branches. As of 2023, Android uses versions 4.14, 4.19, 5.4, 5.10 or 5.15 of the Linux kernel (and since modified Linux kernels are used, kernels are often named like android13-5.15 or android-4.19-stable).[189] The actual kernel depends on the individual device.[190]
                
                Android's variant of the Linux kernel has further architectural changes that are implemented by Google outside the typical Linux kernel development cycle, such as the inclusion of components like device trees, ashmem, ION, and different out of memory (OOM) handling.[191][192] Certain features that Google contributed back to the Linux kernel, notably a power management feature called "wakelocks",[193] were initially rejected by mainline kernel developers partly because they felt that Google did not show any intent to maintain its own code.[194][195] Google announced in April 2010 that they would hire two employees to work with the Linux kernel community,[196] but Greg Kroah-Hartman, the current Linux kernel maintainer for the stable branch, said in December 2010 that he was concerned that Google was no longer trying to get their code changes included in mainstream Linux.[195] Google engineer Patrick Brady once stated in the company's developer conference that "Android is not Linux",[197] with Computerworld adding that "Let me make it simple for you, without Linux, there is no Android".[198] Ars Technica wrote that "Although Android is built on top of the Linux kernel, the platform has very little in common with the conventional desktop Linux stack".[197]
                
                In August 2011, Linus Torvalds said that "eventually Android and Linux would come back to a common kernel, but it will probably not be for four to five years".[199] (that has not happened yet, while some code has been upstreamed, not all of it has, so modified kernels keep being used). In December 2011, Greg Kroah-Hartman announced the start of Android Mainlining Project, which aims to put some Android drivers, patches and features back into the Linux kernel, starting in Linux 3.3.[200] Linux included the autosleep and wakelocks capabilities in the 3.5 kernel, after many previous attempts at a merger. The interfaces are the same but the upstream Linux implementation allows for two different suspend modes: to memory (the traditional suspend that Android uses), and to disk (hibernate, as it is known on the desktop).[201] Google maintains a public code repository that contains their experimental work to re-base Android off the latest stable Linux versions.[202][203]
                
                Android is a Linux distribution according to the Linux Foundation,[204] Google's open-source chief Chris DiBona,[205] and several journalists.[206][207] Others, such as Google engineer Patrick Brady, say that Android is not Linux in the traditional Unix-like Linux distribution sense; Android does not include the GNU C Library (it uses Bionic as an alternative C library) and some other components typically found in Linux distributions.[208]
                
                With the release of Android Oreo in 2017, Google began to require that devices shipped with new SoCs had Linux kernel version 4.4 or newer, for security reasons. Existing devices upgraded to Oreo, and new products launched with older SoCs, were exempt from this rule.[209][210]
                Rooting
                Main article: Rooting (Android)
                
                The flash storage on Android devices is split into several partitions, such as /system/ for the operating system itself, and /data/ for user data and application installations.[211]
                
                In contrast to typical desktop Linux distributions, Android device owners are not given root access to the operating system and sensitive partitions such as /system/ are partially read-only. However, root access can be obtained by exploiting security flaws in Android, which is used frequently by the open-source community to enhance the capabilities and customizability of their devices, but also by malicious parties to install viruses and malware.[212] Root access can also be obtained by unlocking the bootloader which is available on most Android devices, for example on most Google Pixel, OnePlus and Nothing models OEM Unlocking option in the developer settings allows Fastboot to unlock the bootloader. But most OEMs have their own methods. The unlocking process resets the system to factory state, erasing all user data.[213]
                Software stack
                Android's architecture diagram[obsolete source]
                
                On top of the Linux kernel, there are the middleware, libraries and APIs written in C, and application software running on an application framework which includes Java-compatible libraries. Development of the Linux kernel continues independently of Android's other source code projects.
                
                Android uses Android Runtime (ART) as its runtime environment (introduced in version 4.4), which uses ahead-of-time (AOT) compilation to entirely compile the application bytecode into machine code upon the installation of an application. In Android 4.4, ART was an experimental feature and not enabled by default; it became the only runtime option in the next major version of Android, 5.0.[214] In versions no longer supported, until version 5.0 when ART took over, Android previously used Dalvik as a process virtual machine with trace-based just-in-time (JIT) compilation to run Dalvik "dex-code" (Dalvik Executable), which is usually translated from the Java bytecode. Following the trace-based JIT principle, in addition to interpreting the majority of application code, Dalvik performs the compilation and native execution of select frequently executed code segments ("traces") each time an application is launched.[215][216][217] For its Java library, the Android platform uses a subset of the now discontinued Apache Harmony project.[218] In December 2015, Google announced that the next version of Android would switch to a Java implementation based on the OpenJDK project.[219]
                
                Android's standard C library, Bionic, was developed by Google specifically for Android, as a derivation of the BSD's standard C library code. Bionic itself has been designed with several major features specific to the Linux kernel. The main benefits of using Bionic instead of the GNU C Library (glibc) or uClibc are its smaller runtime footprint, and optimization for low-frequency CPUs. At the same time, Bionic is licensed under the terms of the BSD licence, which Google finds more suitable for the Android's overall licensing model.[217]
                
                Aiming for a different licensing model, toward the end of 2012, Google switched the Bluetooth stack in Android from the GPL-licensed BlueZ to the Apache-licensed BlueDroid.[220] A new Bluetooth stack, called Gabeldorsche, was developed to try to fix the bugs in the BlueDroid implementation.[221]
                
                Android does not have a native X Window System by default, nor does it support the full set of standard GNU libraries. This made it difficult to port existing Linux applications or libraries to Android,[208] until version r5 of the Android Native Development Kit brought support for applications written completely in C or C++.[222] Libraries written in C may also be used in applications by injection of a small shim and usage of the JNI.[223]
                
                In current versions of Android, "Toybox", a collection of command-line utilities (mostly for use by apps, as Android does not provide a command-line interface by default), is used (since the release of Marshmallow) replacing a similar "Toolbox" collection found in previous Android versions.[224]
                
                Android has another operating system, Trusty OS, within it, as a part of "Trusty" "software components supporting a Trusted Execution Environment (TEE) on mobile devices." "Trusty and the Trusty API are subject to change. [..] Applications for the Trusty OS can be written in C/C++ (C++ support is limited), and they have access to a small C library. [..] All Trusty applications are single-threaded; multithreading in Trusty userspace currently is unsupported. [..] Third-party application development is not supported in" the current version, and software running on the OS and processor for it, run the "DRM framework for protected content. [..] There are many other uses for a TEE such as mobile payments, secure banking, full-disk encryption, multi-factor authentication, device reset protection, replay-protected persistent storage, wireless display ("cast") of protected content, secure PIN and fingerprint processing, and even malware detection."[225]
                Open-source community
                
                Android's source code is released by Google under an open-source license, and its open nature has encouraged a large community of developers and enthusiasts to use the open-source code as a foundation for community-driven projects, which deliver updates to older devices, add new features for advanced users or bring Android to devices originally shipped with other operating systems.[226] These community-developed releases often bring new features and updates to devices faster than through the official manufacturer/carrier channels, with a comparable level of quality;[227] provide continued support for older devices that no longer receive official updates; or bring Android to devices that were officially released running other operating systems, such as the HP TouchPad. Community releases often come pre-rooted and contain modifications not provided by the original vendor, such as the ability to overclock or over/undervolt the device's processor.[228] CyanogenMod was the most widely used community firmware,[229] now discontinued and succeeded by LineageOS.[230]
                
                There are, as of August 2019, a handful of notable custom Android distributions (ROMs) of Android version 9.0 Pie, which was released publicly in August 2018. See List of custom Android distributions.
                
                Historically, device manufacturers and mobile carriers have typically been unsupportive of third-party firmware development. Manufacturers express concern about improper functioning of devices running unofficial software and the support costs resulting from this.[231] Moreover, modified firmware such as CyanogenMod sometimes offer features, such as tethering, for which carriers would otherwise charge a premium. As a result, technical obstacles including locked bootloaders and restricted access to root permissions are common in many devices. However, as community-developed software has grown more popular, and following a statement by the Librarian of Congress in the United States that permits the "jailbreaking" of mobile devices,[232] manufacturers and carriers have softened their position regarding third party development, with some, including HTC,[231] Motorola,[233] Samsung[234][235] and Sony,[236] providing support and encouraging development. As a result of this, over time the need to circumvent hardware restrictions to install unofficial firmware has lessened as an increasing number of devices are shipped with unlocked or unlockable bootloaders, similar to Nexus series of phones, although usually requiring that users waive their devices' warranties to do so.[231] However, despite manufacturer acceptance, some carriers in the US still require that phones are locked down.[237]
                Device codenames
                
                Internally, Android identifies each supported device by its device codename, a short string,[238] which may or may not be similar to the model name used in marketing the device. For example, the device codename of the Pixel smartphone is sailfish.
                
                The device codename is usually not visible to the end user, but is important for determining compatibility with modified Android versions. It is sometimes also mentioned in articles discussing a device, because it allows to distinguish different hardware variants of a device, even if the manufacturer offers them under the same name. The device codename is available to running applications under android.os.Build.DEVICE.[239]
                Security and privacy
                See also: Mobile security and Comparison of open-source mobile phones
                
                In 2020, Google launched the Android Partner Vulnerability Initiative to improve the security of Android.[240][241] They also formed an Android security team.[242]
                Common security threats
                
                Research from security company Trend Micro lists premium service abuse as the most common type of Android malware, where text messages are sent from infected phones to premium-rate telephone numbers without the consent or even knowledge of the user. Other malware displays unwanted and intrusive advertisements on the device, or sends personal information to unauthorised third parties.[243] Security threats on Android are reportedly growing exponentially; however, Google engineers have argued that the malware and virus threat on Android is being exaggerated by security companies for commercial reasons,[244][245] and have accused the security industry of playing on fears to sell virus protection software to users.[244] Google maintains that dangerous malware is actually extremely rare,[245] and a survey conducted by F-Secure showed that only 0.5% of Android malware reported had come from the Google Play store.[246]
                
                In 2021, journalists and researchers reported the discovery of spyware, called Pegasus, developed and distributed by a private company which can and has been used to infect both iOS and Android smartphones often – partly via use of 0-day exploits – without the need for any user-interaction or significant clues to the user and then be used to exfiltrate data, track user locations, capture film through its camera, and activate the microphone at any time.[247] Analysis of data traffic by popular smartphones running variants of Android found substantial by-default data collection and sharing with no opt-out by this pre-installed software.[248][249] Both of these issues are not addressed or cannot be addressed by security patches.
                Scope of surveillance by public institutions
                See also: WARRIOR PRIDE
                
                As part of the broader 2013 mass surveillance disclosures it was revealed in September 2013 that the American and British intelligence agencies, the National Security Agency (NSA) and Government Communications Headquarters (GCHQ), respectively, have access to the user data on iPhone, BlackBerry, and Android devices. They are reportedly able to read almost all smartphone information, including SMS, location, emails, and notes.[250] In January 2014, further reports revealed the intelligence agencies' capabilities to intercept the personal information transmitted across the Internet by social networks and other popular applications such as Angry Birds, which collect personal information of their users for advertising and other commercial reasons. GCHQ has, according to The Guardian, a wiki-style guide of different apps and advertising networks, and the different data that can be siphoned from each.[251] Later that week, the Finnish Angry Birds developer Rovio announced that it was reconsidering its relationships with its advertising platforms in the light of these revelations, and called upon the wider industry to do the same.[252]
                
                The documents revealed a further effort by the intelligence agencies to intercept Google Maps searches and queries submitted from Android and other smartphones to collect location information in bulk.[251] The NSA and GCHQ insist their activities comply with all relevant domestic and international laws, although the Guardian stated "the latest disclosures could also add to mounting public concern about how the technology sector collects and uses information, especially for those outside the US, who enjoy fewer privacy protections than Americans."[251]
                
                Leaked documents codenamed Vault 7 and dated from 2013 to 2016, detail the capabilities of the Central Intelligence Agency (CIA) to perform electronic surveillance and cyber warfare, including the ability to compromise the operating systems of most smartphones (including Android).[253][254]
                Security patches
                
                In August 2015, Google announced that devices in the Google Nexus series would begin to receive monthly security patches. Google also wrote that "Nexus devices will continue to receive major updates for at least two years and security patches for the longer of three years from initial availability or 18 months from last sale of the device via the Google Store."[255][256][257] The following October, researchers at the University of Cambridge concluded that 87.7% of Android phones in use had known but unpatched security vulnerabilities due to lack of updates and support.[258][259][260] Ron Amadeo of Ars Technica wrote also in August 2015 that "Android was originally designed, above all else, to be widely adopted. Google was starting from scratch with zero percent market share, so it was happy to give up control and give everyone a seat at the table in exchange for adoption. [...] Now, though, Android has around 75–80 percent of the worldwide smartphone market—making it not just the world's most popular mobile operating system but arguably the most popular operating system, period. As such, security has become a big issue. Android still uses a software update chain-of-command designed back when the Android ecosystem had zero devices to update, and it just doesn't work".[261] Following news of Google's monthly schedule, some manufacturers, including Samsung and LG, promised to issue monthly security updates,[262] but, as noted by Jerry Hildenbrand in Android Central in February 2016, "instead we got a few updates on specific versions of a small handful of models. And a bunch of broken promises".[263]
                
                In a March 2017 post on Google's Security Blog, Android security leads Adrian Ludwig and Mel Miller wrote that "More than 735 million devices from 200+ manufacturers received a platform security update in 2016" and that "Our carrier and hardware partners helped expand deployment of these updates, releasing updates for over half of the top 50 devices worldwide in the last quarter of 2016". They also wrote that "About half of devices in use at the end of 2016 had not received a platform security update in the previous year", stating that their work would continue to focus on streamlining the security updates program for easier deployment by manufacturers.[264] Furthermore, in a comment to TechCrunch, Ludwig stated that the wait time for security updates had been reduced from "six to nine weeks down to just a few days", with 78% of flagship devices in North America being up-to-date on security at the end of 2016.[265]
                
                Patches to bugs found in the core operating system often do not reach users of older and lower-priced devices.[266][267] However, the open-source nature of Android allows security contractors to take existing devices and adapt them for highly secure uses. For example, Samsung has worked with General Dynamics through their Open Kernel Labs acquisition to rebuild Jelly Bean on top of their hardened microvisor for the "Knox" project.[268][269]
                Location-tracking
                
                Android smartphones have the ability to report the location of Wi-Fi access points, encountered as phone users move around, to build databases containing the physical locations of hundreds of millions of such access points. These databases form electronic maps to locate smartphones, allowing them to run apps like Foursquare, Google Latitude, Facebook Places, and to deliver location-based ads.[270] Third party monitoring software such as TaintDroid,[271] an academic research-funded project, can, in some cases, detect when personal information is being sent from applications to remote servers.[272]
                Further notable exploits
                
                In 2018, Norwegian security firm Promon has unearthed a serious Android security hole which can be exploited to steal login credentials, access messages, and track location, which could be found in all versions of Android, including Android 10. The vulnerability came by exploiting a bug in the multitasking system enabling a malicious app to overlay legitimate apps with fake login screens that users are not aware of when handing in security credentials. Users can also be tricked into granting additional permissions to the malicious apps, which later enable them to perform various nefarious activities, including intercepting texts or calls and stealing banking credentials.[273] Avast Threat Labs also discovered that many pre-installed apps on several hundred new Android devices contain dangerous malware and adware. Some of the preinstalled malware can commit ad fraud or even take over its host device.[274][275]
                
                In 2020, the Which? watchdog reported that more than a billion Android devices released in 2012 or earlier, which was 40% of Android devices worldwide, were at risk of being hacked. This conclusion stemmed from the fact that no security updates were issued for the Android versions below 7.0 in 2019. Which? collaborated with the AV Comparatives anti-virus lab to infect five phone models with malware, and it succeeded in each case. Google refused to comment on the watchdog's speculations.[276]
                
                On August 5, 2020, Twitter published a blog urging its users to update their applications to the latest version with regards to a security concern that allowed others to access direct messages. A hacker could easily use the "Android system permissions" to fetch the account credentials in order to do so. The security issue is only with Android 8 (Android Oreo) and Android 9 (Android Pie). Twitter confirmed that updating the app will restrict such practices.[277]
                Technical security features
                
                Android applications run in a sandbox, an isolated area of the system that does not have access to the rest of the system's resources, unless access permissions are explicitly granted by the user when the application is installed, however this may not be possible for pre-installed apps. It is not possible, for example, to turn off the microphone access of the pre-installed camera app without disabling the camera completely. This is valid also in Android versions 7 and 8.[278]
                
                Since February 2012, Google has used its Google Bouncer malware scanner to watch over and scan apps available in the Google Play store.[279][280] A "Verify Apps" feature was introduced in November 2012, as part of the Android 4.2 "Jelly Bean" operating system version, to scan all apps, both from Google Play and from third-party sources, for malicious behaviour.[281] Originally only doing so during installation, Verify Apps received an update in 2014 to "constantly" scan apps, and in 2017 the feature was made visible to users through a menu in Settings.[282][283]
                
                Before installing an application, the Google Play store displays a list of the requirements an app needs to function. After reviewing these permissions, the user can choose to accept or refuse them, installing the application only if they accept.[284] In Android 6.0 "Marshmallow", the permissions system was changed; apps are no longer automatically granted all of their specified permissions at installation time. An opt-in system is used instead, in which users are prompted to grant or deny individual permissions to an app when they are needed for the first time. Applications remember the grants, which can be revoked by the user at any time. Pre-installed apps, however, are not always part of this approach. In some cases it may not be possible to deny certain permissions to pre-installed apps, nor be possible to disable them. The Google Play Services app cannot be uninstalled, nor disabled. Any force stop attempt, result in the app restarting itself.[285][286] The new permissions model is used only by applications developed for Marshmallow using its software development kit (SDK), and older apps will continue to use the previous all-or-nothing approach. Permissions can still be revoked for those apps, though this might prevent them from working properly, and a warning is displayed to that effect.[287][288]
                
                In September 2014, Jason Nova of Android Authority reported on a study by the German security company Fraunhofer AISEC in antivirus software and malware threats on Android. Nova wrote that "The Android operating system deals with software packages by sandboxing them; this does not allow applications to list the directory contents of other apps to keep the system safe. By not allowing the antivirus to list the directories of other apps after installation, applications that show no inherent suspicious behavior when downloaded are cleared as safe. If then later on parts of the app are activated that turn out to be malicious, the antivirus will have no way to know since it is inside the app and out of the antivirus' jurisdiction". The study by Fraunhofer AISEC, examining antivirus software from Avast, AVG, Bitdefender, ESET, F-Secure, Kaspersky, Lookout, McAfee (formerly Intel Security), Norton, Sophos, and Trend Micro, revealed that "the tested antivirus apps do not provide protection against customized malware or targeted attacks", and that "the tested antivirus apps were also not able to detect malware which is completely unknown to date but does not make any efforts to hide its malignity".[289]
                
                In August 2013, Google announced Android Device Manager (renamed Find My Device in May 2017),[290][291] a service that allows users to remotely track, locate, and wipe their Android device,[292][293] with an Android app for the service released in December.[294][295] In December 2016, Google introduced a Trusted Contacts app, letting users request location-tracking of loved ones during emergencies.[296][297] In 2020, Trusted Contacts was shut down and the location-sharing feature rolled into Google Maps.[298]
                
                On October 8, 2018, Google announced new Google Play store requirements to combat over-sharing of potentially sensitive information, including call and text logs. The issue stems from the fact that many apps request permissions to access users' personal information (even if this information is not needed for the app to function) and some users unquestionably grant these permissions. Alternatively, a permission might be listed in the app manifest as required (as opposed to optional) and the app would not install unless user grants the permission; users can withdraw any, even required, permissions from any app in the device settings after app installation, but few users do this. Google promised to work with developers and create exceptions if their apps require Phone or SMS permissions for "core app functionality". The new policies enforcement started on January 6, 2019, 90 days after policy announcement on October 8, 2018. Furthermore, Google announced a new "target API level requirement" (targetSdkVersion in manifest) at least Android 8.0 (API level 26) for all new apps and app updates. The API level requirement might combat the practice of app developers bypassing some permission screens by specifying early Android versions that had a coarser permission model.[299][300]
                Verified Boot
                
                The Android Open Source Project implements a verified boot chain with intentions to verify that executed code, such as the kernel or bootloader, comes from an official source instead of a malicious actor. This implementation establishes a full chain of trust, as it initially starts at a hardware level. Subsequently, the boot loader is verified and system partitions such as system and vendor are checked for integrity.[301][302]
                
                Furthermore, this process verifies that a previous version of Android has not been installed. This effectively provides rollback protection, which mitigates exploits that are similar to a downgrade attack.[301]
                dm-verity
                See also: Device mapper
                
                Android (all supported versions, as far back as version 4.4 of the Android Open Source Project) has the option to provide a verified boot chain with dm-verity. This is a feature in the Linux kernel that allows for transparent integrity checking of block devices.[303][304]
                
                This feature is designed to mitigate persistent rootkits.
                Google Play Services and vendor changes
                See also: Behavioral targeting and DeGoogle
                
                Dependence on proprietary Google Play Services and customizations added on top of the operating system by vendors who license Android from Google is causing privacy concerns.[305][306][307]
                Licensing
                Diagram representing the Android Open Source Project platform
                
                The source code for Android is open-source: it is developed in private by Google, with the source code released publicly when a new version of Android is released. Google publishes most of the code (including network and telephony stacks) under the non-copyleft Apache License version 2.0. which allows modification and redistribution.[308][309] The license does not grant rights to the "Android" trademark, so device manufacturers and wireless carriers have to license it from Google under individual contracts. Associated Linux kernel changes are released under the copyleft GNU General Public License version 2, developed by the Open Handset Alliance, with the source code publicly available at all times.[310] The only Android release which was not immediately made available as source code was the tablet-only 3.0 Honeycomb release. The reason, according to Andy Rubin in an official Android blog post, was because Honeycomb was rushed for production of the Motorola Xoom,[311] and they did not want third parties creating a "really bad user experience" by attempting to put onto smartphones a version of Android intended for tablets.[312]
                
                Only the base Android operating system (including some applications) is open-source software, whereas most Android devices ship with a substantial amount of proprietary software, such as Google Mobile Services, which includes applications such as Google Play Store, Google Search, and Google Play Services – a software layer that provides APIs for the integration with Google-provided services, among others. These applications must be licensed from Google by device makers, and can only be shipped on devices which meet its compatibility guidelines and other requirements.[115] Custom, certified distributions of Android produced by manufacturers (such as Samsung Experience) may also replace certain stock Android apps with their own proprietary variants and add additional software not included in the stock Android operating system.[114] With the advent of the Google Pixel line of devices, Google itself has also made specific Android features timed or permanent exclusives to the Pixel series.[313][314] There may also be "binary blob" drivers required for certain hardware components in the device.[114][166] The best known fully open source Android services are the LineageOS distribution and MicroG which acts as an open source replacement of Google Play Services.
                
                Richard Stallman and the Free Software Foundation have been critical of Android and have recommended the usage of alternatives such as Replicant, because drivers and firmware vital for the proper functioning of Android devices are usually proprietary, and because the Google Play Store application can forcibly install or uninstall applications and, as a result, invite non-free software. In both cases, the use of closed-source software causes the system to become vulnerable to backdoors.[315][316]
                
                It has been argued that because developers are often required to purchase the Google-branded Android license, this has turned the theoretically open system into a freemium service.[317]: 20 
                Leverage over manufacturers
                
                Google licenses their Google Mobile Services software, along with the Android trademarks, only to hardware manufacturers for devices that meet Google's compatibility standards specified in the Android Compatibility Program document.[318] Thus, forks of Android that make major changes to the operating system itself do not include any of Google's non-free components, stay incompatible with applications that require them, and must ship with an alternative software marketplace in lieu of Google Play Store.[114] A prominent example of such an Android fork is Amazon's Fire OS, which is used on the Kindle Fire line of tablets, and oriented toward Amazon services.[114] The shipment of Android devices without GMS is also common in mainland China, as Google does not do business there.[319][320][321]
                
                In 2014, Google also began to require that all Android devices which license the Google Mobile Services software display a prominent "Powered by Android" logo on their boot screens.[115] Google has also enforced preferential bundling and placement of Google Mobile Services on devices, including mandated bundling of the entire main suite of Google applications, mandatory placement of shortcuts to Google Search and the Play Store app on or near the main home screen page in its default configuration,[322] and granting a larger share of search revenue to OEMs who agree to not include third-party app stores on their devices.[323] In March 2018, it was reported that Google had begun to block "uncertified" Android devices from using Google Mobile Services software, and display a warning indicating that "the device manufacturer has preloaded Google apps and services without certification from Google". Users of custom ROMs can register their device ID to their Google account to remove this block.[324]
                
                Some stock applications and components in AOSP code that were formerly used by earlier versions of Android, such as Search, Music, Calendar, and the location API, were abandoned by Google in favor of non-free replacements distributed through Play Store (Google Search, Google Play Music, and Google Calendar) and Google Play Services, which are no longer open-source. Moreover, open-source variants of some applications also exclude functions that are present in their non-free versions.[114][325][326][327] These measures are likely intended to discourage forks and encourage commercial licensing in line with Google requirements, as the majority of the operating system's core functionality is dependent on proprietary components licensed exclusively by Google, and it would take significant development resources to develop an alternative suite of software and APIs to replicate or replace them. Apps that do not use Google components would also be at a functional disadvantage, as they can only use APIs contained within the OS itself. In turn, third-party apps may have dependencies on Google Play Services.[328]
                
                Members of the Open Handset Alliance, which include the majority of Android OEMs, are also contractually forbidden from producing Android devices based on forks of the OS;[114][329] in 2012, Acer Inc. was forced by Google to halt production on a device powered by Alibaba Group's Aliyun OS with threats of removal from the OHA, as Google deemed the platform to be an incompatible version of Android. Alibaba Group defended the allegations, arguing that the OS was a distinct platform from Android (primarily using HTML5 apps), but incorporated portions of Android's platform to allow backwards compatibility with third-party Android software. Indeed, the devices did ship with an application store which offered Android apps; however, the majority of them were pirated.[330][331][332]
                Reception
                
                Android received a lukewarm reaction when it was unveiled in 2007. Although analysts were impressed with the respected technology companies that had partnered with Google to form the Open Handset Alliance, it was unclear whether mobile phone manufacturers would be willing to replace their existing operating systems with Android.[333] The idea of an open-source, Linux-based development platform sparked interest,[334] but there were additional worries about Android facing strong competition from established players in the smartphone market, such as Nokia and Microsoft, and rival Linux mobile operating systems that were in development.[335] These established players were skeptical: Nokia was quoted as saying "we don't see this as a threat", and a member of Microsoft's Windows Mobile team stated "I don't understand the impact that they are going to have."[336]
                
                Since then Android has grown to become the most widely used smartphone operating system[337][338] and "one of the fastest mobile experiences available".[339] Reviewers have highlighted the open-source nature of the operating system as one of its defining strengths, allowing companies such as Nokia (Nokia X family),[340] Amazon (Kindle Fire), Barnes & Noble (Nook), Ouya, Baidu and others to fork the software and release hardware running their own customised version of Android. As a result, it has been described by technology website Ars Technica as "practically the default operating system for launching new hardware" for companies without their own mobile platforms.[337] This openness and flexibility is also present at the level of the end user: Android allows extensive customisation of devices by their owners and apps are freely available from non-Google app stores and third party websites. These have been cited as among the main advantages of Android phones over others.[337][341]
                
                Despite Android's popularity, including an activation rate three times that of iOS, there have been reports that Google has not been able to leverage their other products and web services successfully to turn Android into the money maker that analysts had expected.[342] The Verge suggested that Google is losing control of Android due to the extensive customization and proliferation of non-Google apps and services – Amazon's Kindle Fire line uses Fire OS, a heavily modified fork of Android which does not include or support any of Google's proprietary components, and requires that users obtain software from its competing Amazon Appstore instead of Play Store.[114] In 2014, in an effort to improve prominence of the Android brand, Google began to require that devices featuring its proprietary components display an Android logo on the boot screen.[115]
                
                Android has suffered from "fragmentation",[343] a situation where the variety of Android devices, in terms of both hardware variations and differences in the software running on them, makes the task of developing applications that work consistently across the ecosystem harder than rival platforms such as iOS where hardware and software varies less. For example, according to data from OpenSignal in July 2013, there were 11,868 models of Android devices, numerous screen sizes and eight Android OS versions simultaneously in use, while the large majority of iOS users have upgraded to the latest iteration of that OS.[344] Critics such as Apple Insider have asserted that fragmentation via hardware and software pushed Android's growth through large volumes of low end, budget-priced devices running older versions of Android. They maintain this forces Android developers to write for the "lowest common denominator" to reach as many users as possible, who have too little incentive to make use of the latest hardware or software features only available on a smaller percentage of devices.[345] However, OpenSignal, who develops both Android and iOS apps, concluded that although fragmentation can make development trickier, Android's wider global reach also increases the potential reward.[344]
                Market share
                Main article: Usage share of operating systems
                
                Android is the most used operating system on phones in virtually all countries, with some countries, such as India, having over 96% market share.[346] On tablets, usage is more even, as iOS is a bit more popular globally.
                
                Research company Canalys estimated in the second quarter of 2009, that Android had a 2.8% share of worldwide smartphone shipments.[347] By May 2010, Android had a 10% worldwide smartphone market share, overtaking Windows Mobile,[348] whilst in the US Android held a 28% share, overtaking iPhone OS.[349] By the fourth quarter of 2010, its worldwide share had grown to 33% of the market becoming the top-selling smartphone platform,[350] overtaking Symbian.[351] In the US it became the top-selling platform in April 2011, overtaking BlackBerry OS with a 31.2% smartphone share, according to comScore.[352]
                
                By the third quarter of 2011, Gartner estimated that more than half (52.5%) of the smartphone sales belonged to Android.[353] By the third quarter of 2012 Android had a 75% share of the global smartphone market according to the research firm IDC.[354]
                
                In July 2011, Google said that 550,000 Android devices were being activated every day,[355] up from 400,000 per day in May,[356] and more than 100 million devices had been activated[357] with 4.4% growth per week.[355] In September 2012, 500 million devices had been activated with 1.3 million activations per day.[358][359] In May 2013, at Google I/O, Sundar Pichai announced that 900 million Android devices had been activated.[360]
                
                Android market share varies by location. In July 2012, "mobile subscribers aged 13+" in the United States using Android were up to 52%,[361] and rose to 90% in China.[362] During the third quarter of 2012, Android's worldwide smartphone shipment market share was 75%,[354] with 750 million devices activated in total. In April 2013, Android had 1.5 million activations per day.[359] As of May 2013, 48 billion application ("app") installation have been performed from the Google Play store,[363] and by September 2013, one billion Android devices had been activated.[364]
                
                As of August 2020, the Google Play store had over 3 million Android applications published,[11][365] and as of May 2016, apps had been downloaded more than 65 billion times.[366] The operating system's success has made it a target for patent litigation as part of the so-called "smartphone wars" between technology companies.[367][368]
                
                Android devices account for more than half of smartphone sales in most markets, including the US, while "only in Japan was Apple on top" (September–November 2013 numbers).[369] At the end of 2013, over 1.5 billion Android smartphones had been sold in the four years since 2010,[370][371] making Android the most sold phone and tablet OS. Three billion Android smartphones were estimated to be sold by the end of 2014 (including previous years). According to Gartner research company, Android-based devices outsold all contenders, every year since 2012.[372] In 2013, it outsold Windows 2.8:1 or by 573 million.[373][374][375] As of 2015, Android has the largest installed base of all operating systems;[21] Since 2013, devices running it also sell more than Windows, iOS and Mac OS X devices combined.[376]
                
                According to StatCounter, which tracks only the use for browsing the web, Android is the most popular mobile operating system since August 2013.[377] Android is the most popular operating system for web browsing in India and several other countries (e.g. virtually all of Asia, with Japan and North Korea exceptions). According to StatCounter, Android is most used on phones in all African countries, and it stated "mobile usage has already overtaken desktop in several countries including India, South Africa and Saudi Arabia",[378] with all countries in Africa having done so already in which mobile (including tablets) usage is at 90.46% (Android only, accounts for 75.81% of all use there).[379][380]
                
                While Android phones in the Western world almost always include Google's proprietary code (such as Google Play) in the otherwise open-source operating system, Google's proprietary code and trademark is increasingly not used in emerging markets; "The growth of AOSP Android devices goes way beyond just China [..] ABI Research claims that 65 million devices shipped globally with open-source Android in the second quarter of [2014], up from 54 million in the first quarter"; depending on country, percent of phones estimated to be based only on AOSP source code, forgoing the Android trademark: Thailand (44%), Philippines (38%), Indonesia (31%), India (21%), Malaysia (24%), Mexico (18%), Brazil (9%).[381]
                
                According to a January 2015 Gartner report, "Android surpassed a billion shipments of devices in 2014, and will continue to grow at a double-digit pace in 2015, with a 26 percent increase year over year." This made it the first time that any general-purpose operating system has reached more than one billion end users within a year: by reaching close to 1.16 billion end users in 2014, Android shipped over four times more than iOS and OS X combined, and over three times more than Microsoft Windows. Gartner expected the whole mobile phone market to "reach two billion units in 2016", including Android.[382] Describing the statistics, Farhad Manjoo wrote in The New York Times that "About one of every two computers sold today is running Android. [It] has become Earth's dominant computing platform."[21]
                
                According to a Statistica's estimate, Android smartphones had an installed base of 1.8 billion units in 2015, which was 76% of the estimated total number of smartphones worldwide.[383][384][a] Android has the largest installed base of any mobile operating system and, since 2013, the highest-selling operating system overall[373][376][386][387][388] with sales in 2012, 2013 and 2014[389] close to the installed base of all PCs.[390]
                
                In the second quarter of 2014, Android's share of the global smartphone shipment market was 84.7%, a new record.[391][392] This had grown to 87.5% worldwide market share by the third quarter of 2016,[393] leaving main competitor iOS with 12.1% market share.[394]
                
                According to an April 2017 StatCounter report, Android overtook Microsoft Windows to become the most popular operating system for total Internet usage.[395][396] It has maintained the plurality since then.[397]
                
                In September 2015, Google announced that Android had 1.4 billion monthly active users.[398][399] This changed to 2 billion monthly active users in May 2017.[400][401]
                Adoption on tablets
                The first-generation Nexus 7 tablet, running Android 4.1 Jelly Bean
                
                Despite its success on smartphones, initially Android tablet adoption was slow,[402] then later caught up with the iPad, in most countries. One of the main causes was the chicken or the egg situation where consumers were hesitant to buy an Android tablet due to a lack of high quality tablet applications, but developers were hesitant to spend time and resources developing tablet applications until there was a significant market for them.[403][404] The content and app "ecosystem" proved more important than hardware specs as the selling point for tablets. Due to the lack of Android tablet-specific applications in 2011, early Android tablets had to make do with existing smartphone applications that were ill-suited to larger screen sizes, whereas the dominance of Apple's iPad was reinforced by the large number of tablet-specific iOS applications.[404][405]
                
                Despite app support in its infancy, a considerable number of Android tablets, like the Barnes & Noble Nook (alongside those using other operating systems, such as the HP TouchPad and BlackBerry PlayBook) were rushed out to market in an attempt to capitalize on the success of the iPad.[404] InfoWorld has suggested that some Android manufacturers initially treated their first tablets as a "Frankenphone business", a short-term low-investment opportunity by placing a smartphone-optimized Android OS (before Android 3.0 Honeycomb for tablets was available) on a device while neglecting user interface. This approach, such as with the Dell Streak, failed to gain market traction with consumers as well as damaging the early reputation of Android tablets.[406][407] Furthermore, several Android tablets such as the Motorola Xoom were priced the same or higher than the iPad, which hurt sales. An exception was the Amazon Kindle Fire, which relied upon lower pricing as well as access to Amazon's ecosystem of applications and content.[404][408]
                
                This began to change in 2012, with the release of the affordable Nexus 7 and a push by Google for developers to write better tablet applications.[409] According to International Data Corporation, shipments of Android-powered tablets surpassed iPads in Q3 2012.[410]
                Barnes & Noble Nook running Android
                
                As of the end of 2013, over 191.6 million Android tablets had sold in three years since 2011.[411][412] This made Android tablets the most-sold type of tablet in 2013, surpassing iPads in the second quarter of 2013.[413]
                
                According to StatCounter's web use statistics, as of 2020, Android tablets represent the majority of tablet devices used in Africa (70%), South America (65%), while less than half elsewhere, e.g. Europe (44%), Asia (44%), North America (34%) and Oceania/Australia (18%). There are countries on all continents where Android tablets are the majority, for example, Mexico.[414]
                
                In March 2016, Galen Gruman of InfoWorld stated that Android devices could be a "real part of your business [..] there's no longer a reason to keep Android at arm's length. It can now be as integral to your mobile portfolio as Apple's iOS devices are".[415] A year earlier, Gruman had stated that Microsoft's own mobile Office apps were "better on iOS and Android" than on Microsoft's own Windows 10 devices.[416]
                Platform information
                Main article: Android version history
                
                The recently released Android 12 is the most popular Android version on smartphones and tablets combined, usage is at 78% for all supported versions, i.e. Android 10 and newer.
                
                As of November 2023, Android 13 is most popular on smartphones at 39%, followed by Android 12, 11 etc. in that reverse order. Usage of Android 11 and newer, i.e. supported versions, is at 73%, the rest of users are not supported with security updates. Android 13 is most popular in the United States, in fact all North American countries, and European countries and Australia, and most of the rest of the continents. Otherwise Android 11 is the most popular single version in e.g. in most countries in Africa.
                
                On tablets, Android 13 is again the most popular single version, at 24%. Usage of Android 11 and newer, i.e. supported versions, is at 49% on Android tablets, and with Pie 9.0, until recently supported, at 65%. The usage share varies a lot by country: e.g. Android 9.0 Pie is the version with the greatest usage share in the United States (also in China and the UK) at 37%, while countries ahead, using mostly recent supported versions include Canada, Mexico, Russia, Austalia and the Nordic countries mostly that all use mostly Android 13.
                Version 	Marketing name 	Release date 	API level 	Kernel 	Launched with
                14 	14 	October 4, 2023 	34 	6.1 	Pixel 8 and Pixel 8 Pro
                13 	13 	August 15, 2022 	33 	5.x 	Pixel 4, Pixel 4 XL, Pixel 4a, Pixel 5, Pixel 5a, Pixel 6, Pixel 6 Pro, Pixel 7, Pixel 7 Pro, Pixel 7a, Asus ZenFone 8, Lenovo P12 Pro, OnePlus 10 Pro, Oppo Find X5 Pro, Vivo X80 Pro, Realme GT2 Pro, Xiaomi 12, Xiaomi 12 Pro, Xiaomi Pad 5, Redmi K50 Pro, Sharp AQUOS sense6, Tecno Camon 19 Pro, ZTE Axon 40 Ultra[417]
                12L 	12 	March 7, 2022 	32 	5.x 	Pixel 3, Pixel 3 XL, Pixel 3a, Pixel 3a XL, Pixel 4, Pixel 4 XL, Pixel 4a, Pixel 5, Pixel 5a
                12 	October 4, 2021 	31 	5.x 	Pixel 3, Pixel 3 XL, Pixel 3a, Pixel 3a XL, Pixel 4, Pixel 4 XL, Pixel 5, Pixel 6, Pixel 6 Pro, Asus ZenFone 8, Nokia X20, OnePlus 9, OnePlus 9 Pro, Oppo Find X3 Pro, iQOO 7 Legend, Realme GT,[418] TCL 20 Pro 5G, Xiaomi Mi 11, Xiaomi Mi 11 Ultra, Xiaomi Mi 11i/Mi 11X Pro,[419] Tecno Camon 17, ZTE Axon 30 Ultra
                11 	11 	September 8, 2020 	30 	5.x 	Pixel 2, Pixel 2 XL, Pixel 3, Pixel 3 XL, Pixel 3a, Pixel 3a XL, Pixel 4, Pixel 4 XL,[420] OnePlus 8, OnePlus 8 Pro, Oppo Find X2, Oppo Find X2 Pro, Vivo NEX 3S, Xiaomi Mi 10, Xiaomi Mi 10 Pro, POCO F2 Pro,[421] Realme X50 Pro, Sharp AQUOS Zero 2
                10 	10 	September 3, 2019 	29 	5.x 	Asus ZenFone 5Z, Essential Phone, Pixel, Pixel XL, Pixel 2, Pixel 2 XL, Pixel 3, Pixel 3 XL, Pixel 3a, Pixel 3a XL, OnePlus 6, OnePlus 6T, OnePlus 7, OnePlus 7 Pro, Oppo Reno, Sony Xperia XZ3, Vivo X27, Vivo NEX S, Vivo NEX A, Xiaomi Mi MIX 3 5G, Xiaomi Mi 9, Tecno Spark 3 Pro, Huawei Mate 20 Pro, LG G8, Nokia 8.1, Realme 3 Pro[422]
                9 	Pie 	August 6, 2018 	28 	4.x 	Essential Phone, Pixel, Pixel XL, Pixel 2, Pixel 2 XL, Nokia 7 Plus, OnePlus 6, Oppo R15 Pro, Sony Xperia XZ2, Vivo X21UD, Vivo X21, Xiaomi Mi Mix 2S[423]
                
                Since January 2023, 85% of devices have Vulkan graphics support (77.0% are on newer Vulkan 1.1),[424] the successor to OpenGL. At the same time 100.0% of the devices have support for OpenGL ES 2.0 or higher, 93% are on OpenGL ES 3.0 or higher, and 80.24% are using the latest version OpenGL ES 3.2.
                Application piracy
                
                Paid Android applications in the past were simple to pirate.[425] In a May 2012 interview with Eurogamer, the developers of Football Manager stated that the ratio of pirated players vs legitimate players was 9:1 for their game Football Manager Handheld.[426] However, not every developer agreed that piracy rates were an issue; for example, in July 2012 the developers of the game Wind-up Knight said that piracy levels of their game were only 12%, and most of the piracy came from China, where people cannot purchase apps from Google Play.[427]
                
                In 2010, Google released a tool for validating authorized purchases for use within apps, but developers complained that this was insufficient and trivial to crack. Google responded that the tool, especially its initial release, was intended as a sample framework for developers to modify and build upon depending on their needs, not as a finished piracy solution.[428] Android "Jelly Bean" introduced the ability for paid applications to be encrypted, so that they may work only on the device for which they were purchased.[429][430]
                Legal issues
                Further information: Smartphone patent wars and Patent troll
                
                The success of Android has made it a target for patent and copyright litigation between technology companies, both Android and Android phone manufacturers having been involved in numerous patent lawsuits and other legal challenges.
                Patent lawsuit with Oracle
                Main article: Oracle v. Google
                
                On August 12, 2010, Oracle sued Google over claimed infringement of copyrights and patents related to the Java programming language.[431] Oracle originally sought damages up to $6.1 billion,[432] but this valuation was rejected by a United States federal judge who asked Oracle to revise the estimate.[433] In response, Google submitted multiple lines of defense, counterclaiming that Android did not infringe on Oracle's patents or copyright, that Oracle's patents were invalid, and several other defenses. They said that Android's Java runtime environment is based on Apache Harmony, a clean room implementation of the Java class libraries, and an independently developed virtual machine called Dalvik.[434] In May 2012, the jury in this case found that Google did not infringe on Oracle's patents, and the trial judge ruled that the structure of the Java APIs used by Google was not copyrightable.[435][436] The parties agreed to zero dollars in statutory damages for a small amount of copied code.[437] On May 9, 2014, the Federal Circuit partially reversed the district court ruling, ruling in Oracle's favor on the copyrightability issue, and remanding the issue of fair use to the district court.[438][439]
                
                In December 2015, Google announced that the next major release of Android (Android Nougat) would switch to OpenJDK, which is the official open-source implementation of the Java platform, instead of using the now-discontinued Apache Harmony project as its runtime. Code reflecting this change was also posted to the AOSP source repository.[218] In its announcement, Google claimed this was part of an effort to create a "common code base" between Java on Android and other platforms.[219] Google later admitted in a court filing that this was part of an effort to address the disputes with Oracle, as its use of OpenJDK code is governed under the GNU General Public License (GPL) with a linking exception, and that "any damages claim associated with the new versions expressly licensed by Oracle under OpenJDK would require a separate analysis of damages from earlier releases".[218] In June 2016, a United States federal court ruled in favor of Google, stating that its use of the APIs was fair use.[440]
                
                In April 2021, the Supreme Court of the United States ruled that Google's use of the Java APIs was within the bounds of fair use, reversing the Federal Circuit Appeals Court ruling and remanding the case for further hearing. The majority opinion began with the assumption that the APIs may be copyrightable, and thus proceeded with a review of the factors that contributed to fair use.[441]
                Anti-competitive challenges in Europe
                Main article: European Union vs. Google
                
                In 2013, FairSearch, a lobbying organization supported by Microsoft, Oracle and others, filed a complaint regarding Android with the European Commission, alleging that its free-of-charge distribution model constituted anti-competitive predatory pricing. The Free Software Foundation Europe, whose donors include Google, disputed the Fairsearch allegations.[442] On April 20, 2016, the EU filed a formal antitrust complaint against Google based upon the FairSearch allegations, arguing that its leverage over Android vendors, including the mandatory bundling of the entire suite of proprietary Google software, hindering the ability for competing search providers to be integrated into Android, and barring vendors from producing devices running forks of Android, constituted anti-competitive practices.[443] In August 2016, Google was fined US$6.75 million by the Russian Federal Antimonopoly Service (FAS) under similar allegations by Yandex.[444] The European Commission issued its decision on July 18, 2018, determining that Google had conducted three operations related to Android that were in violation of antitrust regulations: bundling Google's search and Chrome as part of Android, blocking phone manufacturers from using forked versions of Android, and establishing deals with phone manufacturers and network providers to exclusively bundle the Google search application on handsets (a practice Google ended by 2014). The EU fined Google for €4.3 billion (about US$5 billion) and required the company to end this conduct within 90 days.[445] Google filed its appeal of the ruling in October 2018, though will not ask for any interim measures to delay the onset of conduct requirements.[446]
                
                On October 16, 2018, Google announced that it would change its distribution model for Google Mobile Services in the EU, since part of its revenues streams for Android which came through use of Google Search and Chrome were now prohibited by the EU's ruling. While the core Android system remains free, OEMs in Europe would be required to purchase a paid license to the core suite of Google applications, such as Gmail, Google Maps and the Google Play Store. Google Search will be licensed separately, with an option to include Google Chrome at no additional cost atop Search. European OEMs can bundle third-party alternatives on phones and devices sold to customers, if they so choose. OEMs will no longer be barred from selling any device running incompatible versions of Android in Europe.[447]
                Others
                
                In addition to lawsuits against Google directly, various proxy wars have been waged against Android indirectly by targeting manufacturers of Android devices, with the effect of discouraging manufacturers from adopting the platform by increasing the costs of bringing an Android device to market.[448] Both Apple and Microsoft have sued several manufacturers for patent infringement, with Apple's ongoing legal action against Samsung being a particularly high-profile case. In January 2012, Microsoft said they had signed patent license agreements with eleven Android device manufacturers, whose products account for "70 percent of all Android smartphones" sold in the US[449] and 55% of the worldwide revenue for Android devices.[450] These include Samsung and HTC.[451] Samsung's patent settlement with Microsoft included an agreement to allocate more resources to developing and marketing phones running Microsoft's Windows Phone operating system.[448] Microsoft has also tied its own Android software to patent licenses, requiring the bundling of Microsoft Office Mobile and Skype applications on Android devices to subsidize the licensing fees, while at the same time helping to promote its software lines.[452][453]
                
                Google has publicly expressed its frustration for the current patent landscape in the United States, accusing Apple, Oracle and Microsoft of trying to take down Android through patent litigation, rather than innovating and competing with better products and services.[454] In August 2011, Google purchased Motorola Mobility for US$12.5 billion, which was viewed in part as a defensive measure to protect Android, since Motorola Mobility held more than 17,000 patents.[455][456] In December 2011, Google bought over a thousand patents from IBM.[457]
                
                Turkey's competition authority investigations about the default search engine in Android, started in 2017, led to a US$17.4 million fine in September 2018 and a fine of 0.05 percent of Google's revenue per day in November 2019 when Google did not meet the requirements.[458] In December 2019, Google stopped issuing licenses for new Android phone models sold in Turkey.[458]
                Other uses
                Ouya, a video game console which runs Android
                
                Google has developed several variations of Android for specific use cases, including Android Wear, later renamed Wear OS, for wearable devices such as wrist watches,[459][460] Android TV for televisions,[461][462] Android Things for smart or Internet of things devices and Android Automotive for cars.[463][464] Additionally, by providing infrastructure that combines dedicated hardware and dedicated applications running on regular Android, Google have opened up the platform for its use in particular usage scenarios, such as the Android Auto app for cars,[465][466] and Daydream, a Virtual Reality platform.[467]
                
                The open and customizable nature of Android allows device makers to use it on other electronics as well, including laptops, netbooks,[468][469] and desktop computers,[470] cameras,[471] headphones,[472] home automation systems, game consoles,[473] media players,[474] satellites,[475] routers,[476] printers,[477] payment terminals,[478] automated teller machines,[479] inflight entertainment systems,[480] and robots.[481] Additionally, Android has been installed and run on a variety of less-technical objects, including calculators,[482] single-board computers,[483] feature phones,[484] electronic dictionaries,[485] alarm clocks,[486] refrigerators,[487] landline telephones,[488] coffee machines,[489] bicycles,[490] and mirrors.[473]
                
                Ouya, a video game console running Android, became one of the most successful Kickstarter campaigns, crowdfunding US$8.5m for its development,[491][492] and was later followed by other Android-based consoles, such as Nvidia's Shield Portable – an Android device in a video game controller form factor.[493]
                
                In 2011, Google demonstrated "Android@Home", a home automation technology which uses Android to control a range of household devices including light switches, power sockets and thermostats.[494] Prototype light bulbs were announced that could be controlled from an Android phone or tablet, but Android head Andy Rubin was cautious to note that "turning a lightbulb on and off is nothing new", pointing to numerous failed home automation services. Google, he said, was thinking more ambitiously and the intention was to use their position as a cloud services provider to bring Google products into customers' homes.[495][496]
                Android-x86 running on an ASUS Eee PC netbook
                
                Parrot unveiled an Android-based car stereo system known as Asteroid in 2011,[497] followed by a successor, the touchscreen-based Asteroid Smart, in 2012.[498] In 2013, Clarion released its own Android-based car stereo, the AX1.[499] In January 2014, at the Consumer Electronics Show (CES), Google announced the formation of the Open Automotive Alliance, a group including several major automobile makers (Audi, General Motors, Hyundai, and Honda) and Nvidia, which aims to produce Android-based in-car entertainment systems for automobiles, "[bringing] the best of Android into the automobile in a safe and seamless way."[500]
                
                Android comes preinstalled on a few laptops (a similar functionality of running Android applications is also available in Google's ChromeOS) and can also be installed on personal computers by end users.[501][502] On those platforms Android provides additional functionality for physical keyboards[503] and mice, together with the "Alt-Tab" key combination for switching applications quickly with a keyboard. In December 2014, one reviewer commented that Android's notification system is "vastly more complete and robust than in most environments" and that Android is "absolutely usable" as one's primary desktop operating system.[504]
                
                In October 2015, The Wall Street Journal reported that Android will serve as Google's future main laptop operating system, with the plan to fold ChromeOS into it by 2017.[505][506] Google's Sundar Pichai, who led the development of Android, explained that "mobile as a computing paradigm is eventually going to blend with what we think of as desktop today."[505] Also, back in 2009, Google co-founder Sergey Brin himself said that ChromeOS and Android would "likely converge over time."[507] Lockheimer, who replaced Pichai as head of Android and ChromeOS, responded to this claim with an official Google blog post stating that "While we've been working on ways to bring together the best of both operating systems, there's no plan to phase out ChromeOS [which has] guaranteed auto-updates for five years".[508] That is unlike Android where support is shorter with "EOL dates [being..] at least 3 years [into the future] for Android tablets for education".[509]
                
                At Google I/O in May 2016, Google announced Daydream, a virtual reality platform that relies on a smartphone and provides VR capabilities through a virtual reality headset and controller designed by Google itself.[467] The platform is built into Android starting with Android Nougat, differentiating from standalone support for VR capabilities. The software is available for developers, and was released in 2016.
                Mascot
                Android robot logo
                A giant Android mascot at Googleplex in 2008
                
                The mascot of Android is a green android robot, as related to the software's name. Although it had no official name for a long time, the Android team at Google reportedly call it "Bugdroid".[510] In 2024, a Google blog post revealed its official name, "The Bot".[511][512]
                
                It was designed by then-Google graphic designer Irina Blok on November 5, 2007, when Android was announced. Contrary to reports that she was tasked with a project to create an icon,[513] Blok confirmed in an interview that she independently developed it and made it open source. The robot design was initially not presented to Google, but it quickly became commonplace in the Android development team, with various variations of it created by the developers there who liked the figure, as it was free under a Creative Commons license.[514][515] Its popularity amongst the development team eventually led to Google adopting it as an official icon as part of the Android logo when it launched to consumers in 2008. 
            """);
            post06.setAccount(account01);
            postService.save(post06);
        }
    }
}
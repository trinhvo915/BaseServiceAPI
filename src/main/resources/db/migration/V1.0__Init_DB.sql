SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
    [Id] [uniqueidentifier] NOT NULL,
    [CreationTime] [datetime2](7) NOT NULL,
    [CreatorUserId] [varchar](255) NULL,
    [DeleterUserId] [varchar](255) NULL,
    [DeletionTime] [datetime2](7) NULL,
    [IsDeleted] [bit] NOT NULL,
    [LastModificationTime] [datetime2](7) NULL,
    [LastModifierUserId] [varchar](255) NULL,
    [name] [varchar](255) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    CONSTRAINT [UK_7d8a768x6aiuvmsa24hqiharg] UNIQUE NONCLUSTERED
(
[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO

/****** Object:  Table [dbo].[UserInRole]    Script Date: 11/20/2022 1:32:41 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[UserInRole](
    [UserId] [uniqueidentifier] NOT NULL,
    [RoleId] [uniqueidentifier] NOT NULL,
     PRIMARY KEY CLUSTERED
    (
    [UserId] ASC,
[RoleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO

/****** Object:  Table [dbo].[Users]    Script Date: 11/20/2022 1:32:41 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[Users](
    [Id] [uniqueidentifier] NOT NULL,
    [CreationTime] [datetime2](7) NOT NULL,
    [CreatorUserId] [varchar](255) NULL,
    [DeleterUserId] [varchar](255) NULL,
    [DeletionTime] [datetime2](7) NULL,
    [IsDeleted] [bit] NOT NULL,
    [LastModificationTime] [datetime2](7) NULL,
    [LastModifierUserId] [varchar](255) NULL,
    [about] [text] NULL,
    [address] [varchar](255) NULL,
    [birthday] [date] NULL,
    [email] [varchar](255) NULL,
    [fullName] [varchar](50) NULL,
    [genderUser] [int] NULL,
    [mobile] [varchar](20) NULL,
    [password] [varchar](255) NOT NULL,
    [username] [varchar](255) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
    GO
ALTER TABLE [dbo].[Role] ADD  DEFAULT ((0)) FOR [IsDeleted]
    GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT ((0)) FOR [IsDeleted]
    GO
ALTER TABLE [dbo].[UserInRole]  WITH CHECK ADD  CONSTRAINT [FK695l4h2yf4ydc2fs02ujhslcj] FOREIGN KEY([RoleId])
    REFERENCES [dbo].[Role] ([Id])
    GO
ALTER TABLE [dbo].[UserInRole] CHECK CONSTRAINT [FK695l4h2yf4ydc2fs02ujhslcj]
    GO
ALTER TABLE [dbo].[UserInRole]  WITH CHECK ADD  CONSTRAINT [FKqwkesckfaba3krrr8qkpl2gtj] FOREIGN KEY([UserId])
    REFERENCES [dbo].[Users] ([Id])
    GO
ALTER TABLE [dbo].[UserInRole] CHECK CONSTRAINT [FKqwkesckfaba3krrr8qkpl2gtj]
    GO